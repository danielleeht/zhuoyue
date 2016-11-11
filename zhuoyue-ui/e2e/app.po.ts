import { browser, element, by } from 'protractor';

export class ShardisUiPage {
  navigateTo() {
    return browser.get('/');
  }

  getMainContent() {
    return element(by.css('zhuoyue-app .main-content'));
  }

  getNavigation() {
    return element(by.css('zhuoyue-app .navigation'));
  }

  getFooter() {
    return element(by.css('zhuoyue-app .footer md-card-title'));
  }
}
