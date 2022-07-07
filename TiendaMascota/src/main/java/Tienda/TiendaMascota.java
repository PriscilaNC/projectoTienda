package Tienda;

import Animales.Acuatico;
import Animales.Aereo;
import Animales.Terrestre;
import Personas.Cliente;
import Productos.Accesorio;
import Productos.Alimento;
import Productos.Medicamento;

public class TiendaMascota {
    public static void main(String[] args) {
      main();
    }

  public static void main() {

    Acuatico pez1 = new Acuatico(1,"'Pez dorado 1'","'GoldFish'","'C. auratus'","'Dorado'",0.03,1,8000,true,"'CN'","'Pellet para peces'",true,15);
    Acuatico tortuga1 = new Acuatico(2,"'Tortuga de orejas rojas 1'","'No aplica'","'Trachemys scripta'","'Verde/Amarillo'",2.40,2,18000,false,"'CN'","'Pulgas de mar y pellet tortugas'",true,25);

    Aereo catita1 = new Aereo(1,"'Catita 1'","'No aplica'","'Trachemys scripta elegans'","'Blanco/Celeste'",0.7,2,10000,true,"'AR'","'Semillas'");
    Aereo catita2 = new Aereo(2,"'Catita 2'","'No aplica'","'Trachemys scripta elegans'","'Verde/Turqueza'",0.7,2,10000,false,"'AR'","'Semillas'");

    Terrestre gato1 = new Terrestre (1,"'Gato 1'","'Angora'","'F. silvestris'","'Negro'",2.5,1,15990,false,"'TK'","'Variada'");
    Terrestre perro1 = new Terrestre (2,"'Perro 1'", "'Golden Retriever'","'Canis lupus'","'Dorado'",30,1,100000,false,"'EN'","'Variada'");

    Accesorio cama1 = new Accesorio(1,20000,"'Cama pequeña'","'Cama redonda en colores blanco, rosado, y celeste y verde, de diametro 70cm'", "'Felpa y algodon'","'Cama'");
    Accesorio pelota1 = new Accesorio(2,5000,"'Pelota goma'","'Pelota de goma en colores azul, rojo y amarillo'","'Goma'","'Juguete'");

    Alimento gatos1 = new Alimento(1,8000,"'Croquetas sabor atun'","'Croquetas saludables de atun marca GatoFeliz'","'2022-03-04'","'2024-05-04'","'Gato'",0.2);
    Alimento peces1 = new Alimento(2,2500,"'Pellet peces'","'Pellet surtido comida peces'","'2021-11-20'","'2023-11-20'","'Peces'",0.250);

    Medicamento m1 = new Medicamento(1,8990,"'Pipeta gatos FeliMed'","'Pipeta para gatos hasta 4 kg 0,4ml'","'2021-12-04'","'2025-10-04'","'Pipeta antipulgas'");
    Medicamento m2 = new Medicamento(2,2990,"'Antiparasitario PharmaPet'","'Antiparasitario solido 1 ud. para perros y gatos'","'2022-01-09'","'2026-01-09'","'Antiparasitario'");

    Cliente c1 = new Cliente("204899169", "jabin", 21);
  }
}
