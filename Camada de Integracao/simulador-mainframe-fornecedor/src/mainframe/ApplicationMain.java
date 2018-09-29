package mainframe;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class ApplicationMain {

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			Socket socket = null; 
			OutputStream saida = null;
			InputStream entrada = null;
			String msg =  "{\"identificadorFornecedor\": 1,\"nome\": \"IPhone X\",\"descricao\": \"Esse e um bom celular\",\"quantidadeEstoque\": 10,\"prazoEntrega\": 5,\"urlImagens\": [\"http://localhost/static/img/cel1.png\"]}\r\n";
			scan = new Scanner(System.in);
			do{
				System.out.println("Tecle [ENTER]:");
				String text = scan.nextLine();
				if("sair".equalsIgnoreCase(text.trim())) {
					break;
				}
				
				try {
					int sizeBuffer = 2048;
					byte[] buffer = new byte[sizeBuffer];
								
					socket = new Socket("127.0.0.1", 55000);
					saida = socket.getOutputStream();
					entrada = socket.getInputStream();
					saida.write(msg.getBytes());					
					
					int i = 0;
					while(true) {					
						int c = entrada.read();
						if(c < 0 || (c == '\n' && buffer[i - 1] == '\n')) {
							break;
						}
						buffer[i++] = (byte) c;						
						if(i >= 89) {
							break;
						}
					}
					System.out.println("Resposta: " + new String(buffer));
				}catch(Exception ex) {
					System.out.println("Ocorreu um erro ao conectar no servidor.");
				}finally {
					if(saida != null) {
						saida.close();
					}
					if(entrada != null) {
						entrada.close();
					}
					if(socket != null) {
						socket.close();
					}
					
				}

			}while(true);
			System.out.println("Terminado progroma.");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}finally {
			if(scan != null) {
				scan.close();
			}
		}

	}

}
