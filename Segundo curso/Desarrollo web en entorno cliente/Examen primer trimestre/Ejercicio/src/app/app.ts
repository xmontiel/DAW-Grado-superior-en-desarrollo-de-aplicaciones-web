import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

interface Noticia {
  titulo: string;
  imagen: string;
  texto: string;
  fecha: Date;
}

@Component({
  selector: 'app-root',
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  protected readonly title = signal('blog-noticias');
  
  mensajeError: string = '';
  
  noticias: Noticia[] = [
    {
      titulo: "Angular 18 presenta nuevas características revolucionarias",
      imagen: "https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=800",
      texto: "La nueva versión de Angular trae mejoras significativas en rendimiento y experiencia del desarrollador. Los signals y el nuevo sistema de reactividad prometen cambiar la forma en que construimos aplicaciones.",
      fecha: new Date('2024-11-15')
    },
    {
      titulo: "Guía completa de TypeScript para principiantes",
      imagen: "https://images.unsplash.com/photo-1516116216624-53e697fedbea?w=800",
      texto: "TypeScript se ha convertido en el estándar de la industria para el desarrollo de aplicaciones JavaScript escalables. En este artículo exploramos sus características principales y mejores prácticas.",
      fecha: new Date('2024-11-10')
    }
  ];

  publicar(event: Event, titulo: string, imagen: string, texto: string) {
    event.preventDefault();

    if (!titulo.trim() || !imagen.trim() || !texto.trim()) {
      this.mensajeError = 'Error: Todos los campos son obligatorios. Por favor, rellena todos los datos de la noticia.';
      return;
    }

    const nueva: Noticia = {
      titulo: titulo.trim(),
      imagen: imagen.trim(),
      texto: texto.trim(),
      fecha: new Date()
    }

    this.noticias.unshift(nueva);
    this.mensajeError = '';

    (event.target as HTMLFormElement).reset();
  }

  eliminarNoticia(index: number) {
    this.noticias.splice(index, 1);
  }
}