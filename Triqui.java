import java.util.Scanner;

public class Triqui {

	static int band;
	   public static void main (String args []) {
			
	        Scanner scanner = new Scanner(System.in);
	        String coordenadas = ""; 
	        
	        
	        String[][] triqui = new String[3][3];
		
	        for (int i = 0; i < 3; i++) {
		        	
	            for (int j = 0; j < 3; j++) {
		        		
	                triqui[i][j] = "_";
	            }
	        }
	        
	        System.out.println("---------");
	        System.out.println("|       |");
	        System.out.println("|       |");
	        System.out.println("|       |");
	        System.out.println("---------");
	        int ct = 0;
	        while (ct < 9) {

		        int fila = 0;
		        int col = 0;
		        int s = 0;
		        while (s == 0) {
		        
		            coordenadas = ingresar();
		            int band = comprobar(coordenadas);
		            if (band == 1) {
			        	
		                fila = Integer.parseInt(coordenadas.substring(0, 1));
		                col = Integer.parseInt(coordenadas.substring(2, 3));
		                int sw1 = tamanos(fila, col);
		                if (sw1 == 1) {
			            	
		                    int sw2 = asignar(triqui, fila, col);
		                    if (sw2 == 1) {
			            		
		                        System.out.print("\nThis cell is occupied! Choose another one!");
		                    } else { 
			            	
		                    	triqui = completar(triqui, fila, col);

		                    	int valor = terminar(triqui, fila, col);
		                    	if (valor == 1) {
		                    		
		                    		ct = 10;
		                    		s = 1;
		                    		
		                    	} else {
		                    		
		                    		s = 1;
			                        ct++;
		                    	}

		                    }
		                }
		                
		            } else if (band == 0) {
			        	
		                System.out.print("\nYou should enter numbers!");
		            }
		            
		        }
		        
		        if (s == 1 && ct < 9) {
		        	
		            mostrar(triqui);
		        }
	        }
	    }
	   
	   public static int terminar (String[][] tr, int f, int c) {
		   
		   boolean resultadoX = false;
        boolean resultadoO = false;
        boolean resultado = false;
        resultadoX = verificar(tr, "X");
		    resultadoO = verificar(tr, "O");

		    int sw = 0;
		    int rta = 0;
		    if (resultadoX == false && resultadoO == true) {
		        	
		    	mostrar(tr);
		        System.out.println("\nX wins");
		        sw = 1;
		        rta = 1;
		        
		    }
		    if (sw != 1) {
		        
		        if (resultadoX == true && resultadoO == false) { 

		        	mostrar(tr);
		        	System.out.println("\nO wins");
		        	sw = 1;
		        	rta = 1;
		        	
		        }
		    } 
		        
	        if (sw != 1) {
		        
		        if(resultadoX == false && resultadoO == false) {
		        	
		        	resultado = impossible(tr);

		        	if (resultado == true) {
		        		mostrar(tr);
		        		System.out.print("\nImpossible");
		        		sw = 1;
		        	}
		        }
		    }
		        
		    if (sw != 1) {
		       
		        if(resultadoX == true && resultadoO == true) {
		        	
		        	resultado = impossible(tr);

		        	if (resultado == true) {
		        		mostrar(tr);
		        		System.out.print("\nImpossible");
		        		sw = 1;
		        	}
		        }
		    }
        
		    return rta;
		    
	   }
		
	    public static String[][] completar(String[][] tr, int f, int c) {
			
	        int col = f;
	        int fil = c;
	        int sw = 0;
			
	        if (fil == 1) { 
				
	            fil = 2;
	        } else if(fil == 2){
				
	            fil = 1;
	        } else if (fil == 3) {
				
	            fil = 0;
	        }
			
	        if (col == 1) { 
				
	            col = 0;
	        } else if(col == 2){
				
	            col = 1;
	        } else if (col == 3) {
				
	            col = 2;
	        }

	        if (band == 0) {
	        
	        	tr[fil][col] = "X";
	        	band = 1;
	        	verificar(tr, "X");
	        } else if (band == 1) {
	        	
	        	tr[fil][col] = "O";
	        	band = 0;
	        	verificar(tr, "O");
	        }
			
	        return tr;
	    }
		
	    public static int asignar (String[][] tr, int f, int c) {
			
	        int col = f;
	        int fil = c;
	        int sw = 0;
			
	        if (fil == 1) { 
				
	        fil = 2;
	        } else if(fil == 2){
				
	            fil = 1;
	        } else if (fil == 3) {
				
	            fil = 0;
	        }
			
	        if (col == 1) { 
				
	            col = 0;
	        } else if(col == 2){
				
	            col = 1;
	        } else if (col == 3) {
				
	            col = 2;
	        }
			
	        if (tr[fil][col].equals("X") || tr[fil][col].equals("O")) {

	            sw = 1;
	        }
			
			
	        return sw;
			
	    }
		
	    public static int tamanos(int f, int c) {
			
	        int sw = 0;
			
	        if (!(f >= 1 && f <= 3 && c >= 1 && c <= 3)) {
	    	
	            System.out.print("\nCoordinates should be from 1 to 3!");
	            sw = 0;
	        } else {
	    		
	            sw = 1;
	        }
	        	
	        return sw;
			
	    }
		
	    public static void mostrar (String[][] tr) {
		    
	        System.out.print("---------");
	        for (int i = 0; i < 3; i++) {
		        	
	            System.out.print("\n| ");
	            for (int j = 0; j < 3; j++) {
		        	
	                System.out.print(tr[i][j] + " ");
	            }
	            System.out.print("|");
	        }
	        System.out.print("\n---------"); 
		}
		
	    public static String ingresar() {
			
	        Scanner scanner = new Scanner(System.in);
			
	        System.out.print("\nEnter the coordinates: ");
	        String coordenadas = scanner.nextLine();
	    	
	        return coordenadas;
	    }

	    public static int comprobar(String coord) {
		
	        String valor = coord.substring(0, 1);
	        int sw = 0;
	        if (valor.equals("0") || valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6") || valor.equals("7") || valor.equals("8") || valor.equals("9")) {

	            valor = coord.substring(1, 2);
	            if (valor.equals(" ")) {

	                valor = coord.substring(2,3);
	                if (valor.equals("0") || valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6") || valor.equals("7") || valor.equals("8") || valor.equals("9")) {

	                    sw = 1;
	                } else {
						
	                    sw = 0;
	                }
	            } else {
					
	                sw = 0;
	            }	
	        } else {
				
	            sw = 0;
	        }
			
	        return sw;	
	    }
	    
	    public static boolean verificar(String[][] tr, String v) {
			
	        int ct = 2;
	        boolean rta = false;

	        for (int i = 0; i < 3; i++) {
						
	            if (!tr[i][0].equals(v)) {
							
	                rta = true;
	                break;
	            }
	        }

	        if (rta == true) {
				
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[0][i].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	            }
	        }

	        if (rta == true) {
				
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[i][i].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	            }
	        }

	        if (rta == true) {
				
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[i][ct].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	                ct--;
	            }
	        }

	        if (rta == true) {
					
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[1][i].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	                ct--;
	            }
	        }

	        if (rta == true) {
					
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[i][1].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	                ct--;
	            }
	        }

	        if (rta == true) {
					
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[i][2].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	                ct--;
	            }
	        }
	        
	        if (rta == true) {
				
	            rta =  false;
	            for (int i = 0; i < 3; i++) {
					
	                if (!tr[2][i].equals(v)) {
							
	                    rta = true;
	                    break;
	                }
	                ct--;
	            }
	        }
				
	        return rta;
				
	    }
	    

	    public static boolean impossible(String[][] tr) {
			
	        boolean rta = false;
	        int ctX = 0;
	        int ctO = 0;
	        for (int i = 0; i < 3; i++) {
				
	            for (int j = 0; j < 3; j++) {
					
	                if (tr[i][j].equals("X")) {
						
	                    ctX++;
	                } else if (tr[i][j].equals("O")) {
						
	                    ctO++;
	                }
	            }
	        }
	        boolean rX = verificar(tr, "X");
	        boolean rO = verificar(tr, "O");
	        int total1 = ctX - ctO;
	        int total2 = ctO - ctX;	
	        if (total1 >= 2) {
				
	            return true;
	        } else if (total2 >= 2) {
				
	            return true;
	        } else {
				
	            if (rX == true && rO == true) {
					
	                return false;
	            } else if (rX == false && rO == false) {
					
	                return true;
	            } else {
					
	                return false;
	            }
	        }		
	    }
}

