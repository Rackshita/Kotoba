import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WordService } from '../../services/word.service';

@Component({
  selector: 'app-my-words',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-words.html',
  styleUrl: './my-words.css',
})
export class MyWords {

  words:any[]=[];

  constructor(private wordService:WordService){
    this.loadWords();
  }

  loadWords(){
    this.wordService.getReviewWords()
      .subscribe((res:any)=>{
        this.words=res;
      });
  }

}