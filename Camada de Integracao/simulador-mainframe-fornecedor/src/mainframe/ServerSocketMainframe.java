package mainframe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMainframe {

	public static void main(String[] args) {
		int exitCode = 0;
		int port = 5000;
		if(args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		
		System.out.println("*****************************************************");
		System.out.println("**** SIMULADOR DE MAINFRAME - VERSAO FORNECEDOR ****");
		System.out.println("PORTA: " + port);
		System.out.println("*****************************************************");
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			Socket cliente;
			while(true) {
				cliente = server.accept();
				new ProcessadorRequisicao(cliente).start();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			exitCode = 1;
		}finally {
			System.exit(exitCode);
			try {
				if(server != null) {
					server.close();
				}
			}catch(Exception ex) {}
		}
	}
	
	public static class ProcessadorRequisicao extends Thread{
		private Socket cliente;
		
		public ProcessadorRequisicao(Socket cliente) {
			this.cliente = cliente;
		}
		
		protected void checkClosure(int bite) throws IOException {
			if (bite < 0) {
				throw new IOException("Socket closed during message assembly");
			}
		}
		
		@Override
		public void run() {
			InputStream entrada = null;
			OutputStream saida = null;
			try {
				int n = 0;
				int bite;
				final int SIZE = 5000;
				
				entrada = cliente.getInputStream();
				saida = cliente.getOutputStream();
				
				byte[] buffer = new byte[SIZE];
				
				while (true) {
					bite = entrada.read();
					if (bite < 0 && n == 0) {
						throw new RuntimeException("Stream closed between payloads");
					}
					checkClosure(bite);
					if (n > 0 && bite == '\n' && buffer[n - 1] == '\r') {
						break;
					}
					buffer[n++] = (byte) bite;
					if (n >= SIZE) {
						throw new IOException("CRLF not found before max message length: " + SIZE);
					}
				}	
				
				
				String resposta = "{\"status\": \"OK\", \"dadosRecebido\": " + new String(buffer).replace("\r", "").replace("\n", "").trim() + " }";
				System.out.println(resposta);
				
				saida.write(resposta.getBytes());
				saida.write("\r\n".getBytes());
				saida.flush();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					// entrada.close();
					// saida.close();
					//cliente.close();
				}catch(Exception ex) {}
			}
		}
	}

}
