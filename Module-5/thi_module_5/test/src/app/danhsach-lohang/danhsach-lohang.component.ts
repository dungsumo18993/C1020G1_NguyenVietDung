import { Component, OnInit } from '@angular/core';
import {LoHang} from '../Model/LoHang';
import {LoHangService} from '../lo-hang.service';

@Component({
  selector: 'app-danhsach-lohang',
  templateUrl: './danhsach-lohang.component.html',
  styleUrls: ['./danhsach-lohang.component.scss']
})
export class DanhsachLohangComponent implements OnInit {

  loHangList: LoHang[];
  loHangId: number;
  term: any;
  p: number;

  constructor(private loHangService: LoHangService) { }

  ngOnInit(): void {
    this.loHangService.getAllLoHang().subscribe(data => {
      this.loHangList = data;
    });
  }

  showDelete(id: number) {
    this.loHangId = id;
  }

  delete() {
  }
}
