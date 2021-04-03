import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { articles } from '../article/articles';


@Component({
  selector: 'app-add-new-article',
  templateUrl: './add-new-article.component.html',
  styleUrls: ['./add-new-article.component.scss']
})
export class AddNewArticleComponent implements OnInit {
  articleList = articles;
  @Output() addNewArticle = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  addArticle(newTitle, newUrl) {
    this.articleList.push({
        title: newTitle.value,
        url: newUrl.value,
        like: 0
      })
    this.addNewArticle.emit(this.articleList);
  }
}
