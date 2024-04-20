import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';


import { WebsocketService } from './websocket.service';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HeaderComponent,RouterLink,RouterLinkActive,CommonModule,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers:[HttpClient]
})
export class AppComponent {
  public notifications :any;

    constructor(private webSocketService: WebsocketService) {

		// Open connection with server socket
        let stompClient = this.webSocketService.connect();
        stompClient.connect({}, frame => {

			// Subscribe to notification topic
            stompClient.subscribe('/greettopic/hello', notifications => {
console.log("notifications:: "+notifications);
				// Update notifications attribute with the recent messsage sent from the server
                this.notifications = notifications.body;
            })
        });
    }
 
  
}
