import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WordService } from '../../services/word.service';

@Component({
  selector: 'app-collection',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './collection.html',
  styleUrl: './collection.css'
})
export class Collection {

  words: any[] = [];
  limit: number = 10;

  constructor(private wordService: WordService) {
    this.loadWords();
  }

  loadWords() {
    this.wordService.getN5Words(this.limit)
      .subscribe((res: any) => {
        this.words = res;
      });
  }

  increase() {
    this.limit += 10;
    this.loadWords();
  }

  decrease() {
    if (this.limit > 10) {
      this.limit -= 10;
      this.loadWords();
    }
  }

  startLearning() {

    const ids = this.words.map((w: any) => w.id);

    this.wordService.startReview(ids)
      .subscribe(() => {
        alert("Learning started!");
      });

  }

}