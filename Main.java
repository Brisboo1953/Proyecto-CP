import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static final String HOLA  = ",";
    public static void main(String[] args)throws IOException {
        BufferedReader re = null;
        try{
            re=new BufferedReader(new FileReader("C:/Users/WIN10/Downloads/codigos_postales_hmo"));
            String lineas= re.readLine();
            HashMap<String,Integer> repetidos = new HashMap<>();
            while (lineas!=null){
                String[] celdas = lineas.split(HOLA);
                for (String r: celdas){
                 String columna= lineas.substring(0, Math.min(6,lineas.length()));
                 repetidos.put(columna,repetidos.getOrDefault(columna,0)+1);
                }
                lineas=re.readLine();
            }
            for (String r: repetidos.keySet()){
                int veces=repetidos.get(r);
                if (veces>1){
                    System.out.println("Codigo postal: "+ r + "Repeticones: "+ veces);
                }
            }
        }finally {
            if(re !=null){
                try{
                    re.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}