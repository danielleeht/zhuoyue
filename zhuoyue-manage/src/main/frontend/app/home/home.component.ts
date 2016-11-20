import {Component, OnInit} from '@angular/core';
import {AuthService} from '../shared/auth/auth.service';

@Component({
  selector: 'zhuoyue-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  angularLogo = 'assets/img/angular-logo.png';

  data = {value: ''};

  constructor(public authService: AuthService) {

  }

  ngOnInit() {
    console.log('hello `Home` component');
  }
}
