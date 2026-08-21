import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SeriesService, Serie } from '../../services/series';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class HomeComponent implements OnInit {
  series: Serie[] = [];
  loading = true;
  error: string | null = null;

  constructor(private seriesService: SeriesService) {}

  ngOnInit(): void {
    this.seriesService.getAll().subscribe({
      next: (response) => {
        this.series = response;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Error al cargar las series.';
        this.loading = false;
      }
    });
  }
}
