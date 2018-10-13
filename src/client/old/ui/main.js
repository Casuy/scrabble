(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-container [ngSwitch]=\"ps.page\">\n  <app-login-page *ngSwitchCase=\"'login'\"></app-login-page>\n  <app-lobby-page *ngSwitchCase=\"'lobby'\"></app-lobby-page>\n  <app-game-page *ngSwitchCase=\"'game'\"></app-game-page>\n  <app-result-page *ngSwitchCase=\"'result'\"></app-result-page>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _page_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../page.service */ "./src/page.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(ps) {
        this.ps = ps;
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_page_service__WEBPACK_IMPORTED_MODULE_1__["PageService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _remote_remote_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../remote/remote.service */ "./src/remote/remote.service.ts");
/* harmony import */ var _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login-page/login-page.component */ "./src/app/login-page/login-page.component.ts");
/* harmony import */ var _lobby_page_lobby_page_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./lobby-page/lobby-page.component */ "./src/app/lobby-page/lobby-page.component.ts");
/* harmony import */ var _game_page_game_page_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./game-page/game-page.component */ "./src/app/game-page/game-page.component.ts");
/* harmony import */ var _contextmenu_contextmenu_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./contextmenu/contextmenu.component */ "./src/app/contextmenu/contextmenu.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _result_page_result_page_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./result-page/result-page.component */ "./src/app/result-page/result-page.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                _login_page_login_page_component__WEBPACK_IMPORTED_MODULE_4__["LoginPageComponent"],
                _lobby_page_lobby_page_component__WEBPACK_IMPORTED_MODULE_5__["LobbyPageComponent"],
                _game_page_game_page_component__WEBPACK_IMPORTED_MODULE_6__["GamePageComponent"],
                _contextmenu_contextmenu_component__WEBPACK_IMPORTED_MODULE_7__["ContextmenuComponent"],
                _result_page_result_page_component__WEBPACK_IMPORTED_MODULE_9__["ResultPageComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormsModule"]
            ],
            providers: [_remote_remote_service__WEBPACK_IMPORTED_MODULE_3__["RemoteService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/contextmenu/contextmenu.component.css":
/*!*******************************************************!*\
  !*** ./src/app/contextmenu/contextmenu.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/contextmenu/contextmenu.component.html":
/*!********************************************************!*\
  !*** ./src/app/contextmenu/contextmenu.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"contextmenu\"\n     style=\"position: absolute;\"\n     [style.left.px]=\"x\"\n     [style.right.px]=\"y\">\n  menu\n</div>\n"

/***/ }),

/***/ "./src/app/contextmenu/contextmenu.component.ts":
/*!******************************************************!*\
  !*** ./src/app/contextmenu/contextmenu.component.ts ***!
  \******************************************************/
/*! exports provided: ContextmenuComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContextmenuComponent", function() { return ContextmenuComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ContextmenuComponent = /** @class */ (function () {
    function ContextmenuComponent() {
        this.x = 0;
        this.y = 0;
    }
    ContextmenuComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ContextmenuComponent.prototype, "x", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ContextmenuComponent.prototype, "y", void 0);
    ContextmenuComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-contextmenu',
            template: __webpack_require__(/*! ./contextmenu.component.html */ "./src/app/contextmenu/contextmenu.component.html"),
            styles: [__webpack_require__(/*! ./contextmenu.component.css */ "./src/app/contextmenu/contextmenu.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ContextmenuComponent);
    return ContextmenuComponent;
}());



/***/ }),

/***/ "./src/app/game-page/game-page.component.css":
/*!***************************************************!*\
  !*** ./src/app/game-page/game-page.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container {\n  position: fixed;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  display: flex;\n  flex-flow: row nowrap;\n  justify-content: flex-start;\n  align-items: center;\n  padding: 18px;\n}\n\nsection.board {\n  margin: 0 18px;\n}\n\n.board-row {\n  display: flex;\n  flex-flow: row nowrap;\n}\n\n.board-row:first-child .board-slot {\n  border-top-width: 1px;\n}\n\n.board-slot {\n  height: 24px;\n  width: 24px;\n  display: inline-block;\n  background-color: #fcfaf3;\n  border: 1px solid rgba(11, 16, 19, 0.68);\n  border-top-width: 0;\n  border-right-width: 0;\n  text-align: center;\n  line-height: 24px;\n}\n\n.board-slot:last-child {\n  border-right-width: 1px;\n}\n\n.board-slot-focus {\n  background-color: rgb(189, 192, 186);\n}\n\n.sidebar {\n  display: flex;\n  height: 480px;\n  width: 100%;\n  flex-flow: column nowrap;\n  /*padding: 18px 12px 0 0;*/\n  padding-right: 12px;\n}\n\n.game-user-list {\n  width: 100%;\n  font-size: 12px;\n  line-height: 18px;\n}\n\n.game-user-list th {\n  text-align: left;\n  color: #666666;\n}\n\n.game-user-list .game-user-list-heading {\n  color: initial;\n  font-size: 14px;\n  font-weight: bold;\n  text-align: center;\n  padding-bottom: 16px;\n  /*margin-left: -4px;*/\n}\n\n.aside-block {\n  font-size: 12px;\n  border-radius: 4px;\n  border: 1px solid #dddddd;\n  margin: 0 8px 24px 8px;\n  background-color: #f9f9f9;\n  padding: 12px;\n  overflow: hidden;\n}\n\n.aside-center-block {\n  display: flex;\n  flex-flow: column nowrap;\n  justify-content: center;\n  align-items: center;\n}\n\n.vote-block {\n  line-height: 24px;\n  font-size: 13px;\n}\n\n.vote-block-word {\n  cursor: pointer;\n  font-size: 16px;\n  padding: 4px 4px;\n}\n\n.vote-block-word-active {\n  font-weight: bold;\n}\n\n.vote-block-actions {\n\n}\n"

/***/ }),

/***/ "./src/app/game-page/game-page.component.html":
/*!****************************************************!*\
  !*** ./src/app/game-page/game-page.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<section class=\"container\" *ngIf=\"rs.gameBoard\">\n  <section class=\"board\">\n    <div class=\"board-row\" *ngFor=\"let row of rs.gameBoard.rows; let y=index\">\n      <div class=\"board-slot\"\n           *ngFor=\"let slot of row; let x=index\"\n           [class.board-slot-focus]=\"selectedSlot===slot\"\n           (mousedown)=\"focus($event, x, y)\">\n        {{slot.letter}}\n      </div>\n    </div>\n  </section>\n\n  <!-- right side -->\n  <aside class=\"sidebar\">\n    <section class=\"aside-block\" style=\"position: fixed;top: 100vh;left: 100vw;\">\n      <input type=\"text\" autofocus (input)=\"onKeyDown(input)\" #input (blur)=\"$event.preventDefault()\">\n    </section>\n    <!-- vote board-->\n    <section class=\"aside-block aside-center-block vote-block\" [style.height.px]=\"128\">\n      <div *ngIf=\"rs.game.vote && rs.game.vote.active; then inVoteStage else notInVoteStage\"></div>\n      <!-- vote active -->\n      <ng-template #inVoteStage>\n        <!-- vote for others-->\n        <ng-container *ngIf=\"rs.game.activeUser != rs.username\">\n          <div>Choose the correct words:</div>\n          <div>\n          <span *ngIf=\"rs.game.vote.wordA; let w\"\n                (mousedown)=\"voteSelection.toggle(w)\"\n                class=\"vote-block-word\"\n                [class.vote-block-word-active]=\"voteSelection.isActive(w)\">{{w}}</span>\n            <ng-container *ngIf=\"rs.game.vote.wordB!=rs.game.vote.wordA; \">\n              <ng-container *ngIf=\"rs.game.vote.wordB; let w\">\n                <span>, </span>\n                <span (mousedown)=\"voteSelection.toggle(w)\"\n                      class=\"vote-block-word\"\n                      [class.vote-block-word-active]=\"voteSelection.isActive(w)\">{{w}}</span>\n              </ng-container>\n            </ng-container>\n          </div>\n          <div style=\"display: flex; flex-flow: row nowrap; margin-top: 12px; margin-bottom: -8px\">\n            <div style=\"cursor: pointer;\" (click)=\"rs.gameVote(voteSelection.list)\">Vote</div>\n          </div>\n        </ng-container>\n        <!-- vote for current user -->\n        <div style=\"color: #666666;\" *ngIf=\"rs.game.activeUser == rs.username\">\n          Waiting others to vote...\n        </div>\n      </ng-template>\n      <!-- vote inactive -->\n      <ng-template #notInVoteStage>\n        <div style=\"color: #666666;\">\n          No vote activity now.\n        </div>\n      </ng-template>\n    </section>\n    <!-- scoreboard-->\n    <section class=\"aside-block\">\n      <table class=\"game-user-list\">\n        <thead>\n        <tr>\n          <!--<th></th>-->\n          <th colspan=\"3\" class=\"game-user-list-heading\">\n            Scoreboard\n            <!--<div style=\"width: 100%; height: 8px; border-bottom: 1px solid #666666;\"></div>-->\n          </th>\n        </tr>\n        <tr>\n          <th></th>\n          <th>Name</th>\n          <th>Score</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngFor=\"let u of rs.game.users\">\n          <td style=\"width: 22px;\"><span *ngIf=\"rs.game.activeUser == u.name\">→</span></td>\n          <td>{{u.name}}</td>\n          <td>{{u.score}}</td>\n        </tr>\n        </tbody>\n      </table>\n    </section>\n\n    <section>\n      <button (click)=\"submit()\">Submit</button>\n      <button (click)=\"pass()\">Pass</button>\n      <button (click)=\"rs.gameExit()\">Exit</button>\n    </section>\n\n  </aside>\n</section>\n\n"

/***/ }),

/***/ "./src/app/game-page/game-page.component.ts":
/*!**************************************************!*\
  !*** ./src/app/game-page/game-page.component.ts ***!
  \**************************************************/
/*! exports provided: GamePageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GamePageComponent", function() { return GamePageComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _remote_remote_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../remote/remote.service */ "./src/remote/remote.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var Selection = /** @class */ (function () {
    function Selection() {
        this.s = new Set();
    }
    Selection.prototype.isActive = function (name) {
        return this.s.has(name);
    };
    Selection.prototype.toggle = function (name) {
        var exists = this.s.has(name);
        if (exists) {
            this.s.delete(name);
        }
        else {
            this.s.add(name);
        }
    };
    Object.defineProperty(Selection.prototype, "list", {
        get: function () {
            return Array.from(this.s);
        },
        enumerable: true,
        configurable: true
    });
    return Selection;
}());
var GamePageComponent = /** @class */ (function () {
    function GamePageComponent(rs) {
        this.rs = rs;
        this.lastSelectedSlots = [];
        this.voteSelection = new Selection();
        // console.table(this.board);
    }
    GamePageComponent.prototype.onKeyDown = function (input) {
        var str = input.value;
        var key = str.charAt(str.length - 1);
        var isLetter = !!key.match(/^[a-z]$/i);
        var slotHasLetter = this.selectedSlot.letter;
        var currentUserTurn = this.rs.isCurrentUser(this.rs.game.activeUser);
        var voting = !!this.rs.game.vote && this.rs.game.vote.active;
        if (isLetter && !slotHasLetter && currentUserTurn && !voting) {
            this.lastSelectedSlots.forEach(function (slot) { return slot.update(null); });
            this.lastSelectedSlots = [];
            this.selectedSlot.update(key);
            this.lastModifiedSlot = this.selectedSlot;
        }
        input.value = '';
    };
    GamePageComponent.prototype.focus = function (e, x, y) {
        e.preventDefault();
        if (this.selectedSlot) {
            this.lastSelectedSlots.push(this.selectedSlot);
        }
        this.selectedSlot = this.rs.gameBoard.rows[y][x];
        var input = this.input.nativeElement;
        input.focus();
    };
    GamePageComponent.prototype.submit = function () {
        var pos = this.rs.gameBoard.getPos(this.lastModifiedSlot);
        this.rs.gameSubmit(pos.y, pos.x, this.lastModifiedSlot.letter);
    };
    GamePageComponent.prototype.pass = function () {
        this.rs.gameSubmit();
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])('input'),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"])
    ], GamePageComponent.prototype, "input", void 0);
    GamePageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-game-page',
            template: __webpack_require__(/*! ./game-page.component.html */ "./src/app/game-page/game-page.component.html"),
            styles: [__webpack_require__(/*! ./game-page.component.css */ "./src/app/game-page/game-page.component.css")]
        }),
        __metadata("design:paramtypes", [_remote_remote_service__WEBPACK_IMPORTED_MODULE_1__["RemoteService"]])
    ], GamePageComponent);
    return GamePageComponent;
}());



/***/ }),

/***/ "./src/app/lobby-page/lobby-page.component.css":
/*!*****************************************************!*\
  !*** ./src/app/lobby-page/lobby-page.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container {\n  position: fixed;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  display: flex;\n  flex-flow: row nowrap;\n}\n\n.lobby {\n  position: relative;\n  height: 100%;\n  width: 100%;\n}\n\n.lobby-home {\n  position: absolute;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  display: flex;\n  flex-flow: column nowrap;\n  justify-content: center;\n  align-items: center;\n}\n\n.lobby-room {\n  position: absolute;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  background-color: white;\n  display: flex;\n  flex-flow: column nowrap;\n  justify-content: space-between;\n  padding-bottom: 28px;\n}\n\n.user-list-aside {\n  height: 100%;\n  width: 265px;\n  border-left: 1px solid #cccccc;\n  overflow-y: scroll;\n  overflow-x: hidden;\n}\n\n.user-list-aside-header {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0;\n  background-color: white;\n}\n\n.user-list-aside-title {\n  padding: 22px 22px;\n  font-size: 14px;\n  border-bottom: 1px solid #cccccc;\n  font-weight: bold;\n  text-overflow: ellipsis;\n  white-space: nowrap;\n}\n\n.user-list {\n  font-size: 13px;\n  line-height: 38px;\n  text-overflow: ellipsis;\n}\n\n.user-item {\n  padding: 0 22px;\n}\n\n.user-item + .user-item {\n  border-top: 1px solid #dddddd;\n}\n\n.user-item.user-item-active {\n  background-color: #f9f9f9;\n}\n\n.user-item-text-status {\n  color: gray;\n}\n\n.user-item-text-status:before {\n  content: ' - ';\n}\n\n.user-item-text {\n  text-overflow: ellipsis;\n  white-space: nowrap;\n}\n\n.user-item-actions {\n  line-height: 28px;\n  margin-top: -4px;\n}\n\n.user-item-action {\n  color: #4687b1;\n  cursor: pointer;\n}\n\n.create-room {\n  margin-top: -18px;\n  height: 300px;\n  width: 300px;\n  border-radius: 150px;\n  text-align: center;\n  line-height: 300px;\n  color: #444444;\n  transition: all 200ms;\n  cursor: pointer;\n}\n\n.create-room:hover {\n  color: #111111;\n  background-color: rgba(0, 0, 0, 0.05);\n}\n\n.create-room:active {\n  background-color: rgba(0, 0, 0, 0.08);\n}\n\n.lobby-room-id-left-text {\n  font-weight: bold;\n  letter-spacing: -1px;\n}\n\n/*.lobby-room-main {*/\n\n/*padding: 24px 38px;*/\n\n/*display: flex;*/\n\n/*flex-flow: row nowrap;*/\n\n/*justify-content: center;*/\n\n/*}*/\n\n.lobby-room header {\n  padding: 24px 38px;\n  font-size: 18px;\n}\n\n.lobby-room-users {\n  padding: 24px 38px;\n  display: flex;\n  flex-flow: row nowrap;\n  justify-content: center;\n  /*border: 1px solid #aaaaaa;*/\n  /*width: 225px;*/\n  /*height: 200px;*/\n  /*padding: 4px;*/\n}\n\n.lobby-room-user {\n  padding: 52px 18px 0 18px;\n  text-align: center;\n  line-height: 22px;\n  font-size: 12px;\n  border-radius: 4px;\n  height: 86px;\n  min-width: 68px;\n  background: #eeeeee;\n}\n\n.lobby-room-user:hover {\n  -webkit-transform: scale(1.01);\n          transform: scale(1.01);\n}\n\n.lobby-room-user + .lobby-room-user {\n  margin-left: 24px;\n}\n\n.lobby-room-actions {\n  padding: 24px 38px;\n  display: flex;\n  flex-flow: row nowrap;\n  justify-content: center;\n}\n\n.lobby-room-action {\n  /*height: 28px;*/\n  /*padding: 0 24px;*/\n  /*text-align: center;*/\n  /*font-size: 12px;*/\n  /*border-radius: 4px;*/\n  /*border: 1px solid #888888;*/\n  /*transition: all 75ms;*/\n}\n\n.lobby-room-action:hover {\n  background-color: #eeeeee;\n}\n\n.lobby-room-action:active {\n  background-color: #dddddd;\n}\n\n.lobby-room-action + .lobby-room-action {\n  margin-left: 12px;\n}\n\n.lobby-room-action.lobby-room-action-x {\n  width: 28px;\n  padding: 0;\n  border-radius: 14px;\n  border: none;\n  transition: all 159ms;\n}\n\n.lobby-room-action.lobby-room-action-x:hover {\n  background-color: #d0d0d0;\n}\n\n.lobby-room-action.lobby-room-action-x:active {\n  background-color: #c0c0c0;\n}\n\n.aside-inv {\n  background-color: #dddddd;\n  width: 100%;\n  height: 58px;\n  font-size: 12px;\n  padding: 12px 24px;\n  display: flex;\n  flex-flow: nowrap row;\n  justify-content: space-between;\n  align-items: center;\n}\n\n.aside-inv-header {\n  font-weight: bold;\n  font-size: 14px;\n  margin-bottom: 8px;\n}\n\n.aside-inv-actions {\n  margin-right: -22px;\n  display: flex;\n  flex-flow: nowrap row;\n}\n\n.aside-inv-action {\n  padding: 6px;\n  cursor: pointer;\n}\n\n.aside-inv-action:hover {\n  color: #0d65a9;\n  font-weight: bold;\n}\n"

/***/ }),

/***/ "./src/app/lobby-page/lobby-page.component.html":
/*!******************************************************!*\
  !*** ./src/app/lobby-page/lobby-page.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <section class=\"lobby\">\n\n    <!-- lobby -->\n    <section class=\"lobby-home\">\n      <div class=\"create-room\"\n           (click)=\"rs.createRoom()\">\n        Create a Room\n      </div>\n    </section>\n\n    <!-- room -->\n    <section class=\"lobby-room\" *ngIf=\"rs.inRoom\">\n      <header><span class=\"lobby-room-id-left-text\">Room:</span> {{rs.room.id}}</header>\n      <section class=\"lobby-room-main\">\n        <section class=\"lobby-room-users\">\n          <div class=\"lobby-room-user\"\n               *ngFor=\"let u of rs.room.users\">{{u}}\n          </div>\n        </section>\n      </section>\n      <section class=\"lobby-room-actions\">\n        <button class=\"lobby-room-action lobby-room-action-x\" (click)=\"rs.leaveRoom()\">X</button>\n        <button class=\"lobby-room-action\" (click)=\"rs.startGame()\" [disabled]=\"rs.room.users.length<2\">Start Game\n        </button>\n      </section>\n    </section>\n\n  </section>\n  <!-- aside: user list -->\n  <aside class=\"user-list-aside\" oncontextmenu=\"return false;\">\n    <header class=\"user-list-aside-header\">\n      <div class=\"user-list-aside-title\">{{currentUser.name}}</div>\n      <!-- invitation panel -->\n      <section class=\"aside-inv\" *ngIf=\"rs.invitation; let inv\">\n        <div>\n          <div class=\"aside-inv-header\">{{inv.invitor}}</div>\n          <div>Join a game?</div>\n        </div>\n        <div class=\"aside-inv-actions\">\n          <div class=\"aside-inv-action\" (click)=\"rs.acceptRoomInvitation(inv.roomId)\">Y</div>\n          <div class=\"aside-inv-action\" (click)=\"rs.refuseRoomInvitation(inv.roomId)\">N</div>\n        </div>\n      </section>\n    </header>\n\n    <!-- user list-->\n    <div class=\"user-list\">\n      <div class=\"user-item\" *ngFor=\"let u of otherUsers\"\n           [class.user-item-active]=\"operatingUser==u\">\n        <div class=\"user-item-text\" (mousedown)=\"operatingUser=operatingUser==u?null:u\" (contextmenu)=\"operatingUser=u\">\n          <span>{{u.name}}</span>\n          <span class=\"user-item-text-status\" *ngIf=\"u.inRoom&&!u.inGame\">In Room</span>\n          <span class=\"user-item-text-status\" *ngIf=\"u.inGame\">Playing</span>\n        </div>\n        <div class=\"user-item-actions\" *ngIf=\"operatingUser==u&&u.name!=rs.username&&currentUser.inRoom\">\n          <span class=\"user-item-action\" (click)=\"invite(u.name)\">Invite</span>\n        </div>\n      </div>\n    </div>\n  </aside>\n</div>\n"

/***/ }),

/***/ "./src/app/lobby-page/lobby-page.component.ts":
/*!****************************************************!*\
  !*** ./src/app/lobby-page/lobby-page.component.ts ***!
  \****************************************************/
/*! exports provided: LobbyPageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LobbyPageComponent", function() { return LobbyPageComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _remote_remote_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../remote/remote.service */ "./src/remote/remote.service.ts");
/* harmony import */ var _page_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../page.service */ "./src/page.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LobbyPageComponent = /** @class */ (function () {
    function LobbyPageComponent(rs, ps) {
        this.rs = rs;
        this.ps = ps;
        this.showRoom = false;
    }
    LobbyPageComponent.prototype.ngOnInit = function () {
    };
    LobbyPageComponent.prototype.invite = function (name) {
        this.rs.roomInvite(name);
        this.operatingUser = null;
    };
    Object.defineProperty(LobbyPageComponent.prototype, "currentUser", {
        get: function () {
            var _this = this;
            return this.rs.users.filter(function (u) { return u.name === _this.rs.username; })[0];
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(LobbyPageComponent.prototype, "otherUsers", {
        get: function () {
            var _this = this;
            return this.rs.users.filter(function (u) { return u.name !== _this.rs.username; });
        },
        enumerable: true,
        configurable: true
    });
    LobbyPageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-lobby-page',
            template: __webpack_require__(/*! ./lobby-page.component.html */ "./src/app/lobby-page/lobby-page.component.html"),
            styles: [__webpack_require__(/*! ./lobby-page.component.css */ "./src/app/lobby-page/lobby-page.component.css")]
        }),
        __metadata("design:paramtypes", [_remote_remote_service__WEBPACK_IMPORTED_MODULE_1__["RemoteService"], _page_service__WEBPACK_IMPORTED_MODULE_2__["PageService"]])
    ], LobbyPageComponent);
    return LobbyPageComponent;
}());



/***/ }),

/***/ "./src/app/login-page/login-page.component.css":
/*!*****************************************************!*\
  !*** ./src/app/login-page/login-page.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".login-area {\n  display: flex;\n  flex-flow: column nowrap;\n  align-items: center;\n  margin: 48px;\n}\n\n.form-control {\n  width: 255px;\n}\n\n.form-control + .form-control {\n  margin-top: 18px;\n}\n\n.form-control .form-control-name {\n  font-size: 12px;\n  margin-bottom: 12px;\n}\n\n.form-control input {\n  display: block;\n  height: 32px;\n  line-height: 28px;\n  padding: 0 10px;\n  font-size: 12px;\n  width: 100%;\n  border: 2px solid #cccccc;\n  transition: all 200ms;\n}\n\n.form-control input:focus {\n  border: 2px solid #5297cc;\n}\n\n.form-control button {\n  width: 100%;\n  height: 28px;\n}\n\n.login-form-tabs {\n  text-align: center;\n  margin-bottom: 20px;\n}\n\n.login-form-tab {\n  display: inline-block;\n  padding: 0 4px;\n  font-size: 12px;\n  cursor: pointer;\n  color: #888888;\n}\n\n.login-form-tab:hover {\n  text-decoration: underline;\n  color: #0d65a9;\n}\n\n.login-form-tab-active {\n  color: #0d65a9;\n  font-weight: bold;\n}\n\n.login-form-tabs-separator {\n  font-size: 10px;\n  opacity: 0.5;\n}\n"

/***/ }),

/***/ "./src/app/login-page/login-page.component.html":
/*!******************************************************!*\
  !*** ./src/app/login-page/login-page.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"login-area\">\n  <header style=\"padding: 0; margin-bottom: 38px\">\n    <h2 style=\"font-size: 26px; font-weight: bold\">Scrabble</h2>\n  </header>\n\n  <form (ngSubmit)=\"onSubmit($event, loginForm)\" #loginForm=\"ngForm\">\n    <!-- address -->\n    <div>\n      <div class=\"login-form-tabs\">\n        <span class=\"login-form-tab\"\n              [class.login-form-tab-active]=\"showRemoteConfig==false\"\n              (mousedown)=\"showRemoteConfig=false\">Local</span>\n        <span class=\"login-form-tabs-separator\"> | </span>\n        <span class=\"login-form-tab\"\n              [class.login-form-tab-active]=\"showRemoteConfig==true\"\n              (mousedown)=\"showRemoteConfig=true\">Remote</span>\n      </div>\n      <!-- local address -->\n      <div [hidden]=\"showRemoteConfig\">\n        <div class=\"form-control\">\n          <div class=\"form-control-name\">Local Hostname</div>\n          <input name=\"localHost\" type=\"text\" #lh [ngModel]=\"'localhost'\">\n        </div>\n        <div class=\"form-control\">\n          <div class=\"form-control-name\">Local Port</div>\n          <input name=\"localPort\" type=\"text\" #lp [ngModel]=\"9900\">\n        </div>\n      </div>\n      <!-- remote address -->\n      <div [hidden]=\"!showRemoteConfig\">\n        <div class=\"form-control\">\n          <div class=\"form-control-name\">Remote Hostname</div>\n          <input name=\"remoteHost\" type=\"text\" #rh [ngModel]=\"'localhost'\">\n        </div>\n        <div class=\"form-control\">\n          <div class=\"form-control-name\">Remote Port</div>\n          <input name=\"remotePort\" type=\"text\" #rp [ngModel]=\"9999\">\n        </div>\n      </div>\n    </div>\n\n    <!-- username -->\n    <div class=\"form-control\" style=\"margin-top: 32px\">\n      <div class=\"form-control-name\">Username</div>\n      <input name=\"username\" type=\"text\" #username [placeholder]=\"randomName\" autofocus ngModel>\n    </div>\n\n    <div style=\"font-size: 12px; line-height: 28px; color: #ba4857; height: 56px; margin-top: 8px\">\n      <div [hidden]=\"!rs.loginForm.usernameError\">Username already in use.</div>\n      <div [hidden]=\"!rs.loginForm.clientAddrError\">Illegal client address.</div>\n      <div [hidden]=\"!rs.loginForm.serverError\">Connection failed.</div>\n    </div>\n\n    <div class=\"form-control\" style=\"margin-top: 18px\">\n      <button type=\"submit\">Login</button>\n    </div>\n  </form>\n\n</div>\n"

/***/ }),

/***/ "./src/app/login-page/login-page.component.ts":
/*!****************************************************!*\
  !*** ./src/app/login-page/login-page.component.ts ***!
  \****************************************************/
/*! exports provided: LoginPageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginPageComponent", function() { return LoginPageComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _page_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../page.service */ "./src/page.service.ts");
/* harmony import */ var _remote_remote_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../remote/remote.service */ "./src/remote/remote.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LoginPageComponent = /** @class */ (function () {
    function LoginPageComponent(ps, rs) {
        this.ps = ps;
        this.rs = rs;
        this.showRemoteConfig = true;
        this.setRandomName();
    }
    LoginPageComponent.prototype.ngOnInit = function () {
    };
    LoginPageComponent.prototype.setRandomName = function () {
        var adj = ['a', 'b', 'c', 'd', 'e', 'f'];
        var animals = ['q', 'w', 'e', 'r', 't', 'y'];
        var salt = Date.now() % 10000;
        this.randomName = adj[salt % adj.length] + animals[salt % animals.length] + salt;
    };
    LoginPageComponent.prototype.onSubmit = function (e, loginForm) {
        e.preventDefault();
        var values = loginForm.value;
        values.username = values.username || this.randomName;
        console.log(values);
        // if (!username) {
        //   username = this.randomName;
        // }
        var ok = this.rs.connectAndLogin(values);
        if (ok) {
            this.ps.gotoLobbyPage();
        }
    };
    LoginPageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login-page',
            template: __webpack_require__(/*! ./login-page.component.html */ "./src/app/login-page/login-page.component.html"),
            styles: [__webpack_require__(/*! ./login-page.component.css */ "./src/app/login-page/login-page.component.css")]
        }),
        __metadata("design:paramtypes", [_page_service__WEBPACK_IMPORTED_MODULE_1__["PageService"], _remote_remote_service__WEBPACK_IMPORTED_MODULE_2__["RemoteService"]])
    ], LoginPageComponent);
    return LoginPageComponent;
}());



/***/ }),

/***/ "./src/app/result-page/result-page.component.css":
/*!*******************************************************!*\
  !*** ./src/app/result-page/result-page.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container {\n  position: fixed;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  display: flex;\n  flex-flow: row nowrap;\n  align-items: center;\n  justify-content: center;\n}\n\n.result-board {\n  width: 360px;\n  display: flex;\n  flex-flow: column nowrap;\n  align-items: center;\n  margin-top: -7vh;\n}\n\n.result-board-header {\n  text-align: center;\n  font-size: 22px;\n  font-weight: bold;\n  margin-bottom: 12px;\n}\n\n.detail-title {\n  text-transform: uppercase;\n  font-weight: bold;\n  font-size: 13px;\n  padding: 18px 0 8px 0;\n}\n\n.detail-name {\n  padding-right: 28px;\n  min-width: 230px;\n}\n\n.detail-row {\n  line-height: 24px;\n}\n\n.actions {\n  display: flex;\n  flex-flow: row nowrap;\n  justify-content: center;\n  margin-top: 68px;\n}\n"

/***/ }),

/***/ "./src/app/result-page/result-page.component.html":
/*!********************************************************!*\
  !*** ./src/app/result-page/result-page.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <article class=\"result-board\" *ngIf=\"rs.game\">\n    <header>\n      <h3 class=\"result-board-header\" hidden>\n        <span *ngIf=\"isCurrentUserWinner\">You Win!</span>\n        <span *ngIf=\"!isCurrentUserWinner\">You Lose!</span>\n      </h3>\n    </header>\n    <section class=\"detail-table\">\n      <table>\n        <tr>\n          <td colspan=\"2\" class=\"detail-title\">\n            <span>winner</span>\n            <span *ngIf=\"winners.length\">s</span>\n          </td>\n        </tr>\n        <tr *ngFor=\"let u of winners\" class=\"detail-row\">\n          <td class=\"detail-name\">{{u.name}}</td>\n          <td>{{u.score}}</td>\n        </tr>\n        <tr>\n          <td colspan=\"2\" class=\"detail-title\">\n            <span>loser</span>\n            <span *ngIf=\"losers.length\">s</span>\n          </td>\n        </tr>\n        <tr *ngFor=\"let u of losers\">\n          <td class=\"detail-name\">{{u.name}}</td>\n          <td>{{u.score}}</td>\n        </tr>\n      </table>\n      <div class=\"actions\">\n        <button (click)=\"exit()\">Exit</button>\n      </div>\n    </section>\n  </article>\n</div>\n"

/***/ }),

/***/ "./src/app/result-page/result-page.component.ts":
/*!******************************************************!*\
  !*** ./src/app/result-page/result-page.component.ts ***!
  \******************************************************/
/*! exports provided: ResultPageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ResultPageComponent", function() { return ResultPageComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _remote_remote_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../remote/remote.service */ "./src/remote/remote.service.ts");
/* harmony import */ var _page_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../page.service */ "./src/page.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ResultPageComponent = /** @class */ (function () {
    function ResultPageComponent(rs, ps) {
        this.rs = rs;
        this.ps = ps;
    }
    ResultPageComponent.prototype.ngOnInit = function () {
    };
    Object.defineProperty(ResultPageComponent.prototype, "isCurrentUserWinner", {
        get: function () {
            var _this = this;
            return this.rs.game.users.filter(function (u) { return u.name === _this.rs.username; }).length;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ResultPageComponent.prototype, "maxScore", {
        get: function () {
            return this.rs.game.users
                .reduce(function (a, b) { return a.score > b.score ? a : b; })
                .score;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ResultPageComponent.prototype, "winners", {
        get: function () {
            var _this = this;
            return this.rs.game.users.filter(function (u) { return u.score === _this.maxScore; });
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ResultPageComponent.prototype, "losers", {
        get: function () {
            var _this = this;
            return this.rs.game.users.filter(function (u) { return u.score < _this.maxScore; });
        },
        enumerable: true,
        configurable: true
    });
    ResultPageComponent.prototype.exit = function () {
        this.rs.game = null;
        this.ps.gotoLobbyPage();
    };
    ResultPageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-result-page',
            template: __webpack_require__(/*! ./result-page.component.html */ "./src/app/result-page/result-page.component.html"),
            styles: [__webpack_require__(/*! ./result-page.component.css */ "./src/app/result-page/result-page.component.css")]
        }),
        __metadata("design:paramtypes", [_remote_remote_service__WEBPACK_IMPORTED_MODULE_1__["RemoteService"], _page_service__WEBPACK_IMPORTED_MODULE_2__["PageService"]])
    ], ResultPageComponent);
    return ResultPageComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ "./src/page.service.ts":
/*!*****************************!*\
  !*** ./src/page.service.ts ***!
  \*****************************/
/*! exports provided: PageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PageService", function() { return PageService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var PageService = /** @class */ (function () {
    function PageService() {
        this.page = 'login';
        // this.page = 'result';
    }
    PageService.prototype.goto = function (pageName) {
        this.page = pageName;
    };
    PageService.prototype.gotoLobbyPage = function () {
        this.goto('lobby');
    };
    PageService.prototype.gotoGamePage = function () {
        this.goto('game');
    };
    PageService.prototype.gotoResultPage = function () {
        this.goto('result');
    };
    PageService.prototype.gotoLoginPage = function () {
        this.goto('login');
    };
    PageService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [])
    ], PageService);
    return PageService;
}());



/***/ }),

/***/ "./src/remote/board.ts":
/*!*****************************!*\
  !*** ./src/remote/board.ts ***!
  \*****************************/
/*! exports provided: Board, BoardSlot */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Board", function() { return Board; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BoardSlot", function() { return BoardSlot; });
var Board = /** @class */ (function () {
    function Board() {
        this.rows = (new Array(20))
            .fill(1)
            .map(function () {
            return (new Array(20))
                .fill(1)
                .map(function () { return new BoardSlot(); });
        });
    }
    Board.prototype.update = function (data) {
        var _this = this;
        data.forEach(function (row, y) {
            row.forEach(function (v, x) {
                var slot = _this.rows[y][x];
                slot.unlock();
                slot.update(v);
                if (!!v) {
                    slot.lock();
                }
            });
        });
    };
    Board.prototype.getPos = function (slot) {
        var pos = { x: null, y: null };
        this.rows.forEach(function (row, y) {
            row.forEach(function (slt, x) {
                if (slot === slt) {
                    pos.x = x;
                    pos.y = y;
                }
            });
        });
        return pos;
    };
    return Board;
}());

var BoardSlot = /** @class */ (function () {
    function BoardSlot() {
        this._lock = false;
    }
    BoardSlot.prototype.isFilled = function () {
        return !!this.letter;
    };
    BoardSlot.prototype.update = function (v) {
        if (this._lock) {
            return;
        }
        this.letter = v;
    };
    BoardSlot.prototype.lock = function () {
        this._lock = true;
    };
    BoardSlot.prototype.unlock = function () {
        this._lock = false;
    };
    return BoardSlot;
}());



/***/ }),

/***/ "./src/remote/remote.service.ts":
/*!**************************************!*\
  !*** ./src/remote/remote.service.ts ***!
  \**************************************/
/*! exports provided: RemoteService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RemoteService", function() { return RemoteService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _page_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../page.service */ "./src/page.service.ts");
/* harmony import */ var _remoteServiceReactor__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./remoteServiceReactor */ "./src/remote/remoteServiceReactor.ts");
/* harmony import */ var _board__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./board */ "./src/remote/board.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var RemoteService = /** @class */ (function () {
    function RemoteService(zone, ps) {
        this.zone = zone;
        this.ps = ps;
        this.users = [];
        this.gameBoard = new _board__WEBPACK_IMPORTED_MODULE_3__["Board"]();
        this.loginForm = {
            usernameError: false,
            clientAddrError: false,
            serverError: false
        };
        this.reactor = new _remoteServiceReactor__WEBPACK_IMPORTED_MODULE_2__["RemoteServiceReactor"](this, ps, zone);
    }
    Object.defineProperty(RemoteService.prototype, "inRoom", {
        get: function () {
            return !!this.room;
        },
        enumerable: true,
        configurable: true
    });
    RemoteService.prototype.bindRemote = function () {
        var _this = this;
        // @ts-ignore
        var agent = window['casuyagent'];
        if (agent) {
            // @ts-ignore
            this.s = agent.server;
            // agent.hello();
        }
        else {
            setTimeout(function () {
                // this.game = {
                //   'users': [{'name': 'happysheep9261', 'score': 0}],
                //   'board': [[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]],
                //   'activeUser': 'happysheep9261',
                //   'id': 569993
                // };
                _this.username = 'sleepinghedgehog35691 ';
                _this.game = {
                    'users': [{ 'name': 'sleepinghedgehog3569', 'score': 0 }],
                    'board': [[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, 'f', null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]],
                    'activeUser': 'sleepinghedgehog3569',
                    'vote': { 'active': true, 'wordA': 'f', 'wordB': 'f' },
                    'id': 124278,
                    showResult: false
                };
                _this.gameBoard.update(_this.game.board);
                _this.ps.gotoGamePage();
            }, 1000);
        }
    };
    RemoteService.prototype.isCurrentUser = function (v) {
        switch (typeof v) {
            case 'string':
                return v === this.username;
            case 'object':
                return v['name'] === this.username;
        }
        return false;
    };
    RemoteService.prototype.connectAndLogin = function (params) {
        this.bindRemote();
        if (this.s) {
            this.username = params.username;
            this.s.bindServer(params.remoteHost, params.remotePort);
            var errorCode = this.s.login(params.username, params.localHost, params.localPort);
            this.loginForm.clientAddrError = false;
            this.loginForm.serverError = false;
            this.loginForm.usernameError = false;
            switch (errorCode) {
                case 1:
                    this.loginForm.clientAddrError = true;
                    break;
                case 2:
                    this.loginForm.serverError = true;
                    break;
                case 3:
                    this.loginForm.usernameError = true;
            }
            if (errorCode === 0) {
                return true;
            }
        }
        return false;
    };
    RemoteService.prototype.createRoom = function () {
        if (this.s) {
            this.s.createRoom(this.username);
        }
        else {
            this.room = {
                id: 138289,
                users: ['a', 'b', 'c']
            };
        }
    };
    RemoteService.prototype.leaveRoom = function () {
        if (this.room) {
            var roomId = this.room.id;
            this.room = null;
            if (this.s) {
                this.s.leaveRoom(roomId, this.username);
            }
        }
    };
    RemoteService.prototype.roomInvite = function (invitee) {
        if (this.room) {
            if (this.s) {
                this.s.roomInvite(this.room.id, this.username, invitee);
            }
        }
    };
    RemoteService.prototype.startGame = function () {
        if (this.s) {
            this.s.startGame(this.room.id);
        }
    };
    // @ts-ignore
    RemoteService.prototype.gameSubmit = function (y, x, v) {
        if (y === void 0) { y = -1; }
        if (x === void 0) { x = -1; }
        if (v === void 0) { v = '_PASS'; }
        if (this.s) {
            this.s.gameSubmit(this.username, y, x, v);
        }
    };
    RemoteService.prototype.gameVote = function (selectedWords) {
        this.game.vote.active = false;
        if (this.s) {
            this.s.gameVote(this.username, JSON.stringify(selectedWords));
        }
    };
    RemoteService.prototype.acceptRoomInvitation = function (roomId) {
        this.invitation = null;
        if (this.s) {
            this.s.acceptRoomInvitation(roomId, this.username);
        }
    };
    RemoteService.prototype.refuseRoomInvitation = function (roomId) {
        this.invitation = null;
        if (this.s) {
            this.s.refuseRoomInvitation(roomId, this.username);
        }
    };
    RemoteService.prototype.gameExit = function () {
        if (this.s) {
            this.s.gameExit(this.room.id);
        }
    };
    RemoteService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgZone"], _page_service__WEBPACK_IMPORTED_MODULE_1__["PageService"]])
    ], RemoteService);
    return RemoteService;
}());



/***/ }),

/***/ "./src/remote/remoteServiceReactor.ts":
/*!********************************************!*\
  !*** ./src/remote/remoteServiceReactor.ts ***!
  \********************************************/
/*! exports provided: RemoteServiceReactor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RemoteServiceReactor", function() { return RemoteServiceReactor; });
var RemoteServiceReactor = /** @class */ (function () {
    function RemoteServiceReactor(rs, ps, zone) {
        this.rs = rs;
        this.ps = ps;
        this.zone = zone;
        window['casuyagentreactor'] = this;
    }
    RemoteServiceReactor.prototype.updateRoomState = function (roomJson) {
        var _this = this;
        this.zone.run(function () {
            _this.rs.room = JSON.parse(roomJson);
        });
    };
    RemoteServiceReactor.prototype.updateUserList = function (usersJson) {
        var _this = this;
        this.zone.run(function () {
            _this.rs.users = JSON.parse(usersJson);
        });
    };
    RemoteServiceReactor.prototype.updateGameState = function (gameJson) {
        var _this = this;
        this.zone.run(function () {
            _this.rs.game = JSON.parse(gameJson);
            _this.rs.gameBoard.update(_this.rs.game.board);
            if (_this.rs.game.showResult) {
                _this.ps.gotoResultPage();
            }
            else {
                _this.ps.gotoGamePage();
            }
        });
    };
    RemoteServiceReactor.prototype.updateInvitation = function (invJson) {
        var _this = this;
        this.zone.run(function () {
            _this.rs.invitation = JSON.parse(invJson);
        });
    };
    return RemoteServiceReactor;
}());



/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/casuy/Course/2018-SM2-CS/Distributed System/ass2/ui/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map