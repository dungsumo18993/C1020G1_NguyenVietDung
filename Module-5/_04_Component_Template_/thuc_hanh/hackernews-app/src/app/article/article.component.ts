import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {
  articles;

  constructor() {
  }

  ngOnInit(): void {
  }

  addNewArticle(articleList: any) {
    this.articles = articleList;
  }
}
