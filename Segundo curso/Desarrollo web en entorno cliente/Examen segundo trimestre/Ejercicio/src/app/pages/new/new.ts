import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SeriesService } from '../../services/series';

@Component({
  selector: 'app-new',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './new.html',
  styleUrl: './new.css'
})
export class NewComponent {
  form: FormGroup;
  responseId: string | null = null;
  submitting = false;

  constructor(
    private fb: FormBuilder,
    private seriesService: SeriesService,
    private router: Router
  ) {
    this.form = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      channel: ['', Validators.required],
      rating: [null, [Validators.required, Validators.min(0), Validators.max(10)]]
    });
  }

  get title() { return this.form.get('title'); }
  get channel() { return this.form.get('channel'); }
  get rating() { return this.form.get('rating'); }

  onSubmit(): void {
    if (this.form.invalid) return;
    this.submitting = true;

    const payload = {
      title: this.form.value.title,
      channel: this.form.value.channel,
      rating: Number(this.form.value.rating)
    };

    this.seriesService.create(payload).subscribe({
      next: (response: any) => {
        console.log('Respuesta POST:', response);
        this.responseId = response._id || response.id || JSON.stringify(response);
        setTimeout(() => this.router.navigate(['/home']), 3000);
      },
      error: (err: any) => {
        console.error('Error POST:', err);
        this.submitting = false;
      }
    });
  }
}
