import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'zhuoyue-playground',
  templateUrl: './playground.component.html',
  styleUrls: ['./playground.component.scss']
})
export class PlaygroundComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    console.log('hello `Playground` component');
  }

}
