package com.tiburela.tierrafertil.models;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.tiburela.tierrafertil.database.RealtimDatabase;

import java.util.ArrayList;

public class ProductorTierraFertil {

    private String nombre;
    private String finca;
    private String ubicacion;

    public String getCertificadora() {
        return certificadora;
    }

    private String certificadora;

    public String getNombre() {
        return nombre;
    }

    public String getFinca() {
        return finca;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getArea() {
        return area;
    }

    public String getCajasSemanles() {
        return cajasSemanles;
    }

    public String getGgn() {
        return ggn;
    }

    public String getCodigoMagap() {
        return codigoMagap;
    }

    public String getGrupCertificadora() {
        return grupCertificadora;
    }

    private String area;
    private String cajasSemanles;
    private String ggn;
    private String codigoMagap;
    private String grupCertificadora;
    private String contacto;

    public String getCodigo() {
        return codigo;
    }

    private String codigo;


      //  "	TF-026	","	 AGUIRRE CARPIO CARLOS ALBERTO	","	SANTA CECILIA % CERRITO %LA CHIQUITA	","	EL MANGO-PROGRESO-PASAJE & PUERTO GARZON, CAÑAQUEMADA, PASAJE &PASAJE	","	10 & 4,1344 &2,9607	","	432 & 165& 133	","	MAYACERT&MAYACERT&MAYACERT	","	4056186938749	","	N21389&S/N&S/N	","	0991625349	","	E&E&E	"


    public ProductorTierraFertil(String codigo, String nombre, String finca, String ubicacion, String area, String cajasSemanles, String certificadora,
                                 String ggn, String codigoMagap, String contacto, String grupCertificadora ){
        this.codigo=codigo;
        this.nombre=nombre;
        this.finca=finca;
        this.ubicacion=ubicacion;
        this.area=area;
        this.cajasSemanles=cajasSemanles;
        this.certificadora=certificadora;
        this.ggn=ggn;
        this.codigoMagap=codigoMagap;
        this.contacto=contacto;
        this.grupCertificadora=grupCertificadora;
    }


    private void addValues(){
        ArrayList<ProductorTierraFertil>miList= new ArrayList<>();


        miList.add(new ProductorTierraFertil("	TF-026	","	 AGUIRRE CARPIO CARLOS ALBERTO	","	SANTA CECILIA&CERRITO&LA CHIQUITA	","	EL MANGO-PROGRESO-PASAJE&PUERTO GARZON, CAÑAQUEMADA, PASAJE&PASAJE	","	10&4,1344&2,9607	","	432&165&133	","	MAYACERT&MAYACERT&MAYACERT	","	4056186938749	","	N21389&S/N&S/N	","	0991625349	","	E&E&E	"));
    }

    public ProductorTierraFertil(){


    }

    public ProductorTierraFertil(String nombre, String finca, String ubicacion, String area, String cajasSemanles, String ggn, String codigoMagap, String certificadora, String grupCertificadora) {
        this.nombre = nombre;
        this.finca = finca;
        this.ubicacion = ubicacion;
        this.area = area;
        this.cajasSemanles = cajasSemanles;
        this.ggn = ggn;
        this.codigoMagap = codigoMagap;
        this.grupCertificadora = grupCertificadora;
        this.certificadora=certificadora;
    }



    public static void createobejtAndUpload(){

        ArrayList<ProductorTierraFertil>miList= new ArrayList<>();
        miList.add(new ProductorTierraFertil(" TF-026 ","AGUIRRE CARPIO CARLOS ALBERTO "," SANTA CECILIA&CERRITO&LA CHIQUITA "," EL MANGO-PROGRESO-PASAJE&PUERTO GARZON, CAÑAQUEMADA, PASAJE&PASAJE "," 10&4,1344&2,9607 "," 432&165&133 "," MAYACERT&MAYACERT&MAYACERT "," 4056186938749 "," N21389&S/N&S/N "," 0991625349 "," E&E&E ")); miList.add(new ProductorTierraFertil(" TF-270 ","ALULEMA LUCERO MARTHA NARCISA "," LA VOLUNTAD DE DIOS "," SANTA ELENA, PROGRESO, PASAJE, EL ORO "," 3,50 "," 88,00 "," MAYACERT "," 4063061997791 "," 102634 "," 0987087332 "," TF ")); miList.add(new ProductorTierraFertil(" TF-199 ","ANDRADE ASTUDILLO CESAR ALEJANDRO "," ZACARIAS "," CAÑA QUEMADA - PASAJE "," 10,00 "," 450,00 "," MAYACERT "," 4059883482034 "," N19558 "," 0990579291 "," TF "));
        miList.add(new ProductorTierraFertil(" TF-164 ","APOLO AGUILAR TITO FERNANDO "," SAN ANTONIO "," EL GUABO /SECTOR CERRO AZUL "," 9,40 "," 244,00 "," MAYACERT "," 4059883482041 "," 102773 "," 0991185369 / 0997670454 "," E ")); miList.add(new ProductorTierraFertil(" TF-200 ","ARIAS ARIAS JESSICA LISSETH "," LA FINCA 3 LOTES "," CAÑA QUEMADA - PASAJE "," 3,00 "," 132,00 "," MAYACERT "," 4059883482058 "," 01229 "," 0991183322 "," TF ")); miList.add(new ProductorTierraFertil(" TF-133 ","ARIAS MENDIETA DARWIN ALCIDES "," PORVENIR&EL AHORCADO&EL PORVENIR "," EL CAMBIO - MACHALA&EL PORTON - EL CAMBIO&TRES DE MAYO-EL CAMBIO "," 5,92&3,21&5,96 "," 296&100&292 "," CU&CU&MAYACERT "," 4056186682260 "," 00516&N21092&00517 "," 0961432016 "," IND&IND&TF ")); miList.add(new ProductorTierraFertil(" TF-150 ","ARIAS QUEZADA FRANCISCO ANIBAL "," COOPERATIVA ESPERANZA&SAN FERNANDO "," EL LIMÓN - MACHALA&EL LIMON, MACHALA "," 6,1&3,13 "," 275&141 "," MAYACERT&MAYACERT "," 4056186959645 "," 00536&S/N "," 0997165601 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-165 ","ARICA LEON KIARA MARIA "," EL PARAISO&AURORA "," EL PORTON - EL CAMBIO&LIRA DE ORO, LA PEAÑA, PASAJE, EL ORO "," 6,69&1,81 "," 336&82 "," MAYACERT&MAYACERT "," 4063061673534 "," N20916/ N21718&102635 "," 0939067945 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-005 ","ARICHABALA WILCHES PABLO IVAN "," ANDENAM "," LA AVELINA, PASAJE "," 5,00 "," 125,00 "," MAYACERT "," 4056186456328 "," 11364 "," 0994680741 "," TF ")); miList.add(new ProductorTierraFertil(" TF-120 ","ARMIJOS ORELLANA SEGUNDO JOSE "," LA MERCED "," CAÑAS-VIA MACHALA STA ROSA "," 1,75 "," 88,00 "," MAYACERT "," 4056186685308 "," 101856 "," 0988381069 "," E ")); miList.add(new ProductorTierraFertil(" TF-241 ","ASTUDILLO INGA GLORIA CARMITA "," FLOR AMARILLAL "," FLOR AMARILLAL, EL GUABO, EL ORO "," 4,11 "," 189,00 "," MAYACERT "," 4059883863222 "," 102282 "," 0983380027 / 0990253771 "," E ")); miList.add(new ProductorTierraFertil(" TF-240 ","ASTUDILLO INGA JORGE MACARIO "," FLOR AMARILLAL "," FLOR AMARILLAL, EL GUABO, EL ORO "," 4,12 "," 185,00 "," MAYACERT "," 4059883863239 "," 102279 "," 0988685168 / 0990253771 "," E ")); miList.add(new ProductorTierraFertil(" TF-242 ","ASTUDILLO INGA LUIS ARSECIO "," FLOR AMARILLAL "," FLOR AMARILLAL, EL GUABO, EL ORO "," 4,15 "," 187,00 "," MAYACERT "," 4059883863246 "," 102281 "," 0990253771 "," E ")); miList.add(new ProductorTierraFertil(" TF-039 ","ASTUDILLO INGA NOLBERTO SEGUNDO "," FLOR AMARILLAL "," FLOR AMARILLAL, EL GUABO, EL ORO "," 4,11 "," 185,00 "," MAYACERT "," 4059883863253 "," 06413 "," 0969172248 / 0991867661 "," E ")); miList.add(new ProductorTierraFertil(" TF-243 ","ASTUDILLO INGA ROSA MERCY "," FLOR AMARILLAL "," FLOR AMARILLAL, EL GUABO, EL ORO "," 4,11 "," 177,00 "," MAYACERT "," 4059883863277 "," 102280 "," 0968601513 / 0990253771 "," E ")); miList.add(new ProductorTierraFertil(" TF-130 ","ASTUDILLO UYAGUARI LUIS FLORENCIO "," LA LUCHA&LA RAQUEL&EL MAMEY "," LA RAQUEL-EL GUABO&LA RAQUEL-EL GUABO&LA RAQUEL-EL GUABO "," 5&5&3,66 "," 240&240&168 "," MAYACERT&MAYACERT&MAYACERT "," 4059883863284 "," 00642&00643&N19245 "," 0939655215 "," E&E&E ")); miList.add(new ProductorTierraFertil(" TF-129 ","BARZALLO CALLE NELSON RODRIGO "," LA FLORIDA "," EL RETIRO-MACHALA "," 8,25 "," 347,00 "," MAYACERT "," 4063061998637 "," 101882 "," 0988333287 / 0999178685 "," E ")); miList.add(new ProductorTierraFertil(" TF-097 ","BELTRAN BERMEO SERGIO ESTUARDO "," LA LUZ "," TENGUEL, GUAYAQUIL, GUAYAS "," 5,00 "," 235,00 "," MAYACERT "," 4063061671554 "," N19773 "," 0990241369 "," E ")); miList.add(new ProductorTierraFertil(" TF-210 ","CAJAMARCA BECERRA ANGELA RAFAELA "," LA PITA "," EL RECUERDO, BUENAVISTA, PASAJE, EL ORO "," 4,06 "," 175,00 "," MAYACERT "," 4063061258076 "," 100828 "," 0992245427 "," E ")); miList.add(new ProductorTierraFertil(" TF-169 ","CAJAMARCA BECERRA ESTEBAN VENANCIO "," LA PINTA "," EL ORO - PASAJE-BUENAVISTA - LA CHINGANA "," 5,39 "," 253,00 "," MAYACERT "," 4063061258090 "," N19523 "," 0959418474 / 0981738086 "," E ")); miList.add(new ProductorTierraFertil(" TF-170 ","CAPA ESPINOZA JOSE ADAN "," SAN JOSE "," LOS ANGELES - VIA BALOSA KM 10 - MACHALA "," 2,00 "," 90,00 "," MAYACERT "," 4063061998644 "," 11297 / 01219 "," 0969132653 "," E ")); miList.add(new ProductorTierraFertil(" TF-212 ","CENTENO GONZABAY GUIDO ESTEBAN "," ANGELITA "," MOLLOPONGO, PROGRESO, PASAJE, EL ORO "," 8,03 "," 209,00 "," MAYACERT "," 4063061258113 "," 08031 "," 0985062718 "," E ")); miList.add(new ProductorTierraFertil(" TF-007 ","CHALEN ARICA LEILA IBELIA "," EL ARIAS/JUANA DAMAS/BELLA JUANITA "," LA PEAÑA, PASAJE, EL ORO "," 5,5 "," 247,00 "," MAYACERT "," 4056186938817 "," 01553 / 01554 / N19790 "," 0980642657 "," TF ")); miList.add(new ProductorTierraFertil(" TF-174 ","CONSTANTE TIPAN JUAN ERNESTO "," LA LUZ "," TENGUEL- SAN JOSE - GUAYAS "," 4,00 "," 180,00 "," MAYACERT "," 4063061671615 "," 102597 "," 0994028026 "," E ")); miList.add(new ProductorTierraFertil(" TF-244 ","COYAGO AGURTO ROSA ELVIRA "," 5 HERMANOS II "," CEIBALES, MACHALA, EL ORO "," 5,69 "," 262,00 "," MAYACERT "," 4063061671639 "," 101753 "," 0979201486 "," TF ")); miList.add(new ProductorTierraFertil(" TF-295 "," "," SAN JORGE "," CEIBALES, MACHALA "," 2,53 "," 101,00 "," MAYACERT "," "," 05751 "," "," TF ")); miList.add(new ProductorTierraFertil(" TF-060 ","CUESTA IZURIETA JORGE WASHINGTON "," LA DOMINGA Y LA PUING "," LA MINA, EL GUABO "," 4,00 "," 180,00 "," QCS "," 4063061400208 "," N20537 "," 0960707217 "," IND ")); miList.add(new ProductorTierraFertil(" TF-245 ","DELGADO TIRADO JOSE SANTIAGO "," TRES HERMANOS "," CHAGUANA - EL GUABO, EL ORO "," 9,14 "," 380,00 "," MAYACERT "," 4059883863406 "," N21667 / N21670 "," 0968910110 "," TF ")); miList.add(new ProductorTierraFertil(" TF-014 ","ENCALADA DURAN MAXIMO BOLIVAR "," BUSTAMANTE/ SELVITA 1 "," PEDREGAL, RIO NEGRO, LA VICTORIA, SANTA ROSA "," 4,42 "," 212,00 "," MAYACERT "," 4059883863437 "," 02606 "," 0980928119 "," TF ")); miList.add(new ProductorTierraFertil(" TF-102 ","FARIAS PRIETO OLGA ELADIA "," VOLUNTAD DE DIOS "," CHALACAL-BARBONES-EL GUABO "," 9,00 "," 387,00 "," MAYACERT "," 4056186456434 "," 02785 "," 0994927699 / 0959539846 "," E ")); miList.add(new ProductorTierraFertil(" TF-066 ","GIA AJILA CARMITA PLACIDA "," LA NIETO/LA NIETO 2&SAN FRANCISCO "," LA VIRGINIA-BUENAVISTA-PASAJE&PASAJE, EL ORO "," 8,8&12,6 "," 440&517 "," MAYACERT&MAYACERT "," 4052852674645 "," 100546 / 101817&S/N "," 0939549371 / 0980240936 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-075 ","GONZALEZ APONTE STALIN ALBERTO "," ANGELITA&LA MARIA "," LA IBERIA - EL GUABO&SITIO SABALUCAL - EL GUABO "," 6,56&5 "," 295&225 "," MAYACERT&MAYACERT "," 4056186959607 "," N21420&N20045 "," 0986430262 "," E&TF ")); miList.add(new ProductorTierraFertil(" TF-067 ","GUERRERO PINEDA ELEUTERIO "," LEONARDA "," SAN VICENTE DEL JOBO-ARENILLAS-EL ORO "," 10,08 "," 464,00 "," MAYACERT "," 4052852883450 "," 03235 "," 0982952005 "," E ")); miList.add(new ProductorTierraFertil(" TF-029 ","GUNCAY CAPA PATRICIA DEL CARMEN "," IVANNA "," KM 15-BALOSA-MACHALA "," 4,50 "," 171,00 "," MAYACERT "," 4056186456441 "," 03268 "," 0969132653 "," TF ")); miList.add(new ProductorTierraFertil(" TF-103 ","GUNCAY CORTE ANGEL GERMAN "," LA TORMENTA&LA PRIMAVERA&NUEVA ESPERANZA "," PALESTINA-LA IBERIA-EL GUABO&PRIMAVERA - MACHALA&EL NARANJO, BARBONES, EL GUABO "," 5&3,8&14,12 "," 245&186&565 "," MAYACERT&MAYACERT&MAYACERT "," 4056186456458 "," 10607&N19080&N20802 "," 0989573451 "," E & na&TF ")); miList.add(new ProductorTierraFertil(" TF-053 ","GUNCAY CORTE TELMO ENRIQUE "," PRIMAVERA 1/PRIMAVERA 2&VOLUNTAD DE DIOS&LA CHUNGATA "," LA PRIMAVERA - MACHALA &LA PEAÑA - MACHALA &RIO SALADO, EL GUABO "," 5,9&3,5&3,03 "," 289&165&115 "," MAYACERT&MAYACERT&MAYACERT "," 4059883482140 "," 101148 &S/N&05682 "," 0991501399 / 0994010344 "," E&E&TF ")); miList.add(new ProductorTierraFertil(" TF-018 ","JIMENEZ CALDERON HUGO ENRIQUE "," SAN SILVERIO "," PAJONAL, CAÑAS, MACHALA, EL ORO "," 7,00 "," 322,00 "," MAYACERT "," 4056186456465 "," N19824 "," 0983160061 "," E ")); miList.add(new ProductorTierraFertil(" TF-222 ","JIMENEZ CALDERON JUAN ALBERTO "," SANTA INES "," SANTA INES, CORRALITOS, MACHALA, EL ORO "," 8,00 "," 336,00 "," MAYACERT "," 4063061258120 "," N20838 "," 0998059083 "," E ")); miList.add(new ProductorTierraFertil(" TF-009 ","LAZO ARIAS FRANKLIN VICENTE "," LA LASSO "," LA UNIÓN, MACHALA, EL ORO "," 6,00 "," 288,00 "," MAYACERT "," 4056186456953 "," 03950/101799/101800 "," 0985542009 "," TF ")); miList.add(new ProductorTierraFertil(" TF-172 ","LEON NOLES PEDRO JULIO "," EL ARROZAL 1 "," LA IBERIA - EL GUABO "," 5,16 "," 214,00 "," MAYACERT "," 4063061671899 "," N21521 "," 0993599222 / 0980824703 "," E ")); miList.add(new ProductorTierraFertil(" TF-181 ","LUCERO CORTE JOSE ANDRES "," EL ARROZAL 2 "," PARROQUIA LA IBERIA - EL GUABO "," 1,91 "," 96,00 "," MAYACERT "," 4059883482157 "," 04124 "," 0990134558 "," E ")); miList.add(new ProductorTierraFertil(" TF-183 ","MARIN MARTILLO DARLIN BOLIVAR "," CUATRO HERMANOS "," LA RAQUEL - BARBONES-EL GUABO "," 8,66 "," 384,00 "," MAYACERT "," 4059883863536 "," 03566 "," 0988976375 "," E ")); miList.add(new ProductorTierraFertil(" TF-105 ","MARIN ORELLANA NELSON EDUARDO "," DOS HERMANAS&LA PITA&LAS MALVINAS&ESPERANZA "," CHALACAL-BARBONES-EL GUABO&LA IBERIA, EL GUABO, EL ORO&LA IBERIA, EL GUABO, EL ORO&LA IBERIA, EL GUABO, EL ORO "," 6,24&0,68&1,26&1,01 "," 312&29&55&43 "," MAYACERT&MAYACERT&MAYACERT "," 4056186456977 "," 04243&10841&10840&S/N "," 0997331699 "," E&E&E&E ")); miList.add(new ProductorTierraFertil(" TF-042 ","MEDINA BRITO JOSE ANTONIO "," LA OCHOA "," PROGRESO - PASAJE "," 4,70 "," 141,00 "," MAYACERT "," 4052852867672 "," 08018/ 04331 "," 0979274886 / 0980485473 "," TF ")); miList.add(new ProductorTierraFertil(" TF-043 ","MENDOZA COLLAGUAZO LUIS LAUTARO "," EL RENACER&SAN LUIS "," PROGRESO - PASAJE&ROSA DE ORO, PROGRESO, PASAJE, EL ORO "," 1,23&3 "," 49&129 "," MAYACERT&MAYACERT "," 4063061998668 "," 08016&S/N "," 0989097022 "," TF&TF ")); miList.add(new ProductorTierraFertil(" TF - 266 ","MOLINA ZUÑIGA WALTER HOMERO "," LAS ANIMAS "," LA VICTORIA, STA. ROSA, EL ORO "," 3,91 "," 137,00 "," MAYACERT "," 4063061998675 "," 102886 "," 0985955063 "," TF ")); miList.add(new ProductorTierraFertil(" TF-122 ","NAGUA PARDO NESTOR SANTIAGO "," MERCEDES "," 5 DE AGOSTO-RIO BONITO-EL GUABO "," 6,58 "," 276,00 "," MAYACERT "," 4056186685391 "," 102029 "," 0969059997 "," TF ")); miList.add(new ProductorTierraFertil(" TF-264 ","NAULA LAGUNA WILSON KLEBER "," MARIANITA&MIREY "," LA MINA, EL GUABO, EL ORO&EL SALADO, EL GUABO "," 7&7,93 "," 308&280 "," MAYACERT&MAYACERT "," 4059883482164 "," S/N&S/N "," 0998354492 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-017 ","NUGRA ORTEGA LUIS SERAFIN "," LA VILLA&LA FORTUNA "," PROGRESO- PASAJE&LA FORTUNA, EL GUABO "," 2,2&12 "," 84&336 "," MAYACERT&MAYACERT "," 4063061258137 "," N21558N21725 "," 0991218397 "," TF ")); miList.add(new ProductorTierraFertil(" TF-004 ","ORDOÑEZ LEON CLEOFE NICOLAS "," 3 HERMANOS "," LA IBERIA-EL GUABO "," 12,92 "," 581,00 "," MAYACERT "," 4052852893091 "," 07939/N20940/N20943/N20944 "," 0939269187 "," TF ")); miList.add(new ProductorTierraFertil(" TF-076 ","ORDOÑEZ OCAMPO MARCO TULIO "," SAN MARCOS&SAN MARCOS II "," CEIBALES-MACHALA&CAÑAS, MACHALA, EL ORO "," 17&5,25 "," 714&231 "," MAYACERT&MAYACERT "," 4056186457103 "," 04972&S/N "," 0989104505 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-186 ","ORDOÑEZ OJEDA MARIO ENRIQUE "," DON ORDOÑEZ "," TILLALES - CANTON EL GUABO - PARROQUIA LA IBERIA "," 1,95 "," 96,00 "," MAYACERT "," 4063061998682 "," 04993 "," 0992905577 "," E ")); miList.add(new ProductorTierraFertil(" TF-030 ","ORDOÑEZ OLARTE MARCO VICENTE "," SAN RAMON "," PAJONAL-MACHALA "," 7,00 "," 301,00 "," MAYACERT "," 4052852552028 "," N20803 "," 0984133629 "," TF ")); miList.add(new ProductorTierraFertil(" TF-077 ","ORDOÑEZ OLARTE MARCO VINICIO "," 4 HNOS "," CEIBALES-MACHALA "," 4,87 "," 214,00 "," MAYACERT "," 4056186457097 "," N19921 "," 0984899690 / 0989104505 "," E ")); miList.add(new ProductorTierraFertil(" TF-096 ","PACHECO ORDOÑEZ MARIA EMPERATRIZ "," LA PATERA "," PAJONAL-MACHALA "," 16,00 "," 832,00 "," MAYACERT "," 4056186457110 "," 05105 "," 0992231726 / 0958778180 "," E ")); miList.add(new ProductorTierraFertil(" TF-115 ","PASTUZO CALLE JULIO VICENTE "," JULIA ELENA "," SANTO DOMINGO - EL GUABO "," 7,00 "," 336,00 "," MAYACERT "," 4056186457134 "," 05212 "," 0993817084 "," E ")); miList.add(new ProductorTierraFertil(" TF-114 ","PASTUZO NAULA JULIA ELENA "," SANTA ELENA "," LA LOMA-EL GUABO "," 8,30 "," 374,00 "," MAYACERT "," 4056186457158 "," 05213 "," 0969918406 "," E ")); miList.add(new ProductorTierraFertil(" TF-059 ","PASTUZO NAULA JULIO RICARDO "," SANTA ELENA&LA GONZALEZ "," EL GUABO&LA IBERIA, EL GUABO, EL ORO "," 8,33&1,71 "," 375&75 "," MAYACERT&MAYACERT "," 4056186457165 "," 04801&S/N "," 0993893418 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-099 ","PEREZ QUINTUÑA SANDRA MARGARITA "," LA RAQUEL PALESTINA "," PALESTINA-LA IBERIA-EL GUABO "," 1,00 "," 49,00 "," MAYACERT "," 4056186457172 "," 101598 "," 0990924176 "," E ")); miList.add(new ProductorTierraFertil(" TF-167 ","PESANTEZ URDIALES ANGELITA NOHEMI "," LA VEGA "," SITIO NUEVO-BUENAVISTA-PASAJE "," 2,30 "," 101,00 "," MAYACERT "," 4063061671998 "," S/N "," 0980164628 "," E ")); miList.add(new ProductorTierraFertil(" TF-031 ","PINDO MACAS KLEBER MARTIN "," LA LUZ "," TENGUEL - GUAYAS "," 5,00 "," 210,00 "," MAYACERT "," 4056186939685 "," N21666 "," 0969059994 "," E ")); miList.add(new ProductorTierraFertil(" TF-144 ","PINEDA RAMON SEGUNDO JEOVANNY "," GUARUMAL "," GUARUMAL-MACHALA "," 6,00 "," 294,00 "," MAYACERT "," 4056186939715 "," 07329 "," 0999577856 "," E ")); miList.add(new ProductorTierraFertil(" TF-143 ","PINEDA SAN MARTIN SEGUNDO ANIBAL "," GUARUMAL "," GUARUMAL-MACHALA "," 5,00 "," 245,00 "," MAYACERT "," 4056186939708 "," 05457 "," 0999577856 "," E ")); miList.add(new ProductorTierraFertil(" TF-034 ","POMA TORRES TEOFILO BENIGNO "," EL PORVENIR "," VIA A LAS 3 PUERTAS-ARENILLAS "," 9,30 "," 409,00 "," MAYACERT "," 4059883482188 "," 05489 "," 0989782318 "," E ")); miList.add(new ProductorTierraFertil(" TF-145 ","PROCEL YIGUIN GLORIA BEATRIZ "," LOTE N 25 "," EL PARAISO-LA VICTORIA-STA ROSA "," 4,20 "," 123,00 "," MAYACERT "," 4063061998699 "," 04037 "," 0968874318 "," E ")); miList.add(new ProductorTierraFertil(" TF-189 ","QUIÑONEZ BAQUERIZO MERCEDES ERCILIA "," CRISTO POBRE "," RIO NEGRO - PEDREGAL "," 11,00 "," 440,00 "," MAYACERT "," 4063061258151 "," 00745/00746 "," 0959521929 "," E ")); miList.add(new ProductorTierraFertil(" TF-190 ","QUITUISACA SUCONOTA LUIS GERARDO "," SAN FRANCISCO "," PRIMAVERA-MACHALA "," 7,00 "," 336,00 "," MAYACERT "," 4059883863598 "," 08291 "," 0990390267 "," E ")); miList.add(new ProductorTierraFertil(" TF-160 ","RAMIREZ CAJAMARCA SERAFIN "," EL AHORCADO&EMPERATRIZ "," 3 DE MAYO, EL CAMBIO, MACHALA &CORRALITOS, MACHALA "," 0,86&1,92 "," 39&96 "," MAYACERT&MAYACERT "," 4059883482195 "," 05678&05679 "," 0994756416 "," TF ")); miList.add(new ProductorTierraFertil(" TF-162 ","RAMON JOSE MANUEL "," LA ESPERANZA/FLORES CHICAS "," LA CHINGANA, BUENAVISTA, PASAJE "," 8,56 "," 410,00 "," MAYACERT "," 4056186457196 "," 08243/05698/05699/102270 "," 0959212581 / 0979424765 "," TF ")); miList.add(new ProductorTierraFertil(" TF-065 ","RAMON PACHECO FAUSTO JAVIER "," SAN XAVIER&GUARUMAL "," PAJONAL-CAÑAS-MACHALA&KM 16- VÍA BALOSA, MACHALA "," 12,59&14,17 "," 630&567 "," MAYACERT&MAYACERT "," 4056186457202 "," 06823&N19443 "," 0969647511 "," E&E ")); miList.add(new ProductorTierraFertil(" TF-147 ","RAMON RAMON LUIS HERMINIO "," MAGNOLIA "," LA MAGNOLIA-PASAJE "," 5,90 "," 265,00 "," MAYACERT "," 4059883863567 "," 05712/05760 "," 0994033422 "," E ")); miList.add(new ProductorTierraFertil(" TF-289 ","RAMON SANMARTIN IVAN FLORENCIO "," PUNTA ESPAÑOLA "," RAJARO-EL PROGRESO-PASAJE "," 15,00 "," 450,00 "," MAYACERT "," "," S/N "," 0960222960 / 0997723737 "," TF ")); miList.add(new ProductorTierraFertil(" TF-161 ","ROMERO JUMBO JORGE SAMUEL "," EL PECHICHE&LAURITA "," VIA A LAS 3 PUERTAS-ARENILLAS&VIA A LAS 3 PUERTAS-ARENILLAS "," 7,69&4 "," 354&140 "," MAYACERT&MAYACERT "," 4063061672001 "," 102937&102936 "," 0997281076 "," TF&TF ")); miList.add(new ProductorTierraFertil(" TF-253 ","ROMERO LUDEÑA CARLOS ALBERTO "," LA RAQUEL O PALESTINA "," LA IBERIA, EL GUABO, EL ORO "," 5,00 "," 240,00 "," MAYACERT "," "," S/N "," 0967405495 / 0993700145 "," TF ")); miList.add(new ProductorTierraFertil(" TF-020 ","ROMERO SANCHEZ HIPOLITO BILBERTO "," EL CAIMITO "," VIA A LAS 3 PUERTAS-ARENILLAS "," 5,00 "," 225,00 "," MAYACERT "," 4052852555913 "," 06084 "," 0993703554 "," TF ")); miList.add(new ProductorTierraFertil(" TF-254 ","ROSILLO CALVA PABLO JORGE "," LA PINTA&VERONICA 3 "," MOTUCHE, EL CAMBIO, EL ORO&EL RETIRO, MACHALA, EL ORO "," 4,9&1,56 "," 240&70 "," MAYACERT&MAYACERT "," 4063061258168 "," 102559&N21514 "," 0997221453 "," TF&TF ")); miList.add(new ProductorTierraFertil(" TF-231 ","SAICO SANISACA MARIA DE LAS NUVES "," PALESTINA "," PALESTINA, LAIBERIA, EL GUABO, EL ORO "," 5,00 "," 240,00 "," MAYACERT "," 4063061267450 "," 06387 "," 0997751426 / 0959228879 "," E ")); miList.add(new ProductorTierraFertil(" TF-001 ","SALAZAR ENRIQUEZ JULIO CESAR "," SAN JOSE "," SEIBALES-MACHALA "," 13,00 "," 624,00 "," MAYACERT "," 4052852555883 "," S/N "," 0982943347 "," TF ")); miList.add(new ProductorTierraFertil(" TF-013 ","SALDAÑA FLORES SEGUNDO RAFAEL "," SANDOVAL "," CHONTILLAL-EL GUABO-EL ORO "," 3,00 "," 134,99 "," MAYACERT "," 4056186939722 "," 102395 "," 0939168666 "," TF ")); miList.add(new ProductorTierraFertil(" TF-088 ","SARAGURO SAGBAY MANUEL DE JESUS "," EL ZAPOTE "," BUENAVISTA-PASAJE "," 4,18 "," 201,00 "," MAYACERT "," 4059883863529 "," N21421 "," 0959866469 "," E ")); miList.add(new ProductorTierraFertil(" TF-070 ","SERRANO BATALLAS GONZALO OSWALDO "," SERBAL "," RIO NEGRO- LA VICTORIA- SANTA ROSA "," 6,44 "," 283,00 "," MAYACERT "," 4056186685421 "," 00714 "," 0967708486 "," E ")); miList.add(new ProductorTierraFertil(" TF-079 ","SERRANO FADUL KLEBER FRANCISCO "," SAN FRANCISCO&SAN GERONIMO 1 "," VIA A LA LOMA, SECTOR DE LA ADUANA, EL GUABO&URBAN BOLIVAR RIZZO, ANTIGUA VIA PANAMERICANA, EL GUABO "," 6,94&3,08 "," 292&142 "," MAYACERT&MAYACERT "," 4056186457318 "," 02751&N18655 "," 0993195976 "," E ")); miList.add(new ProductorTierraFertil(" TF-109 ","SOLANO OCAMPO CARLOS BALDWIN "," LA PEPITO "," PALENQUE-LOMA DE FRANCO-PASAJE.EL ORO "," 5,39 "," 253,00 "," MAYACERT "," 4063061258175 "," 102879 "," 0997480419 "," E ")); miList.add(new ProductorTierraFertil(" TF-194 ","TANDAZO DORESILDA "," DORESILDA "," CEIBALES - MACHALA - EL ORO "," 7,88 "," 394,00 "," MAYACERT "," 4059883863505 "," 06656 "," 0988645507 "," E ")); miList.add(new ProductorTierraFertil(" TF-195 ","TENESACA TENESACA JOSE ADOLFO "," SANTA ROSA&SANTA ROSA&EULALIA "," SAN JOSE - TENGUEL - GUAYAQUIL&SAN JOSE, TENGUEL, GUAYAQUIL, GUAYAS&SAN JOSE, TENGUEL, GUAYAS "," 4,8&1&6 "," 240&45&252 "," MAYACERT&MAYACERT&MAYACERT "," 4059883482201 "," 06688&N21678 "," 0993677211 "," E&E&E ")); miList.add(new ProductorTierraFertil(" TF-235 ","TENESACA TENESACA LUIS EMILIO "," ROSITA "," SAN JOSE, TENGUEL, GUAYAS "," 1,89 "," 85,00 "," MAYACERT "," 4063061258182 "," 06690 "," 0939108058 / 0985516538 "," E ")); miList.add(new ProductorTierraFertil(" TF-036 ","TIGRE AGURTO LUIS MANUEL "," MARGARITA "," PALESTINA-EL GUABO "," 5,00 "," 245,00 "," MAYACERT "," 4052852867641 "," S/N "," 0983619310 "," TF ")); miList.add(new ProductorTierraFertil(" TF-040 ","TIGRE DOMINGUEZ CARLOS ALEJANDRO "," PALENQUE "," PALENQUE-PASAJE "," 5,00 "," 225,00 "," MAYACERT "," 4063061673565 "," 102589 "," 0982971605 "," TF ")); miList.add(new ProductorTierraFertil(" TF-022 ","TIGRE SAICO SONIA VERONICA ","SAN CARLOS "," PALESTINA-EL GUABO-EL ORO "," 6,00 "," 270,00 "," MAYACERT "," 4063061672018 "," N21818 / N21889 "," 0991153373 "," TF ")); miList.add(new ProductorTierraFertil(" TF-037 ","TINOCO MORAN WINSTON URBANO ","LOS LIRIOS "," VIA A LA CUCA-ARENILLAS "," 10,00 "," 400,00 "," MAYACERT "," 4052852894449 "," 03548 / 101814 "," 0986998381 "," TF ")); miList.add(new ProductorTierraFertil(" TF-038 ","TORRES PAREDES JOSE LEONIDAS ","NUEVA ROSITA&MARGARITA "," PALESTINA - EL GUABO&LA PALESTINA, LA IBERIA, EL GUABO "," 5&1 "," 250&39 "," MAYACERT&MAYACERT "," 4056186457332 "," 15694&S/N "," 0993207179 "," TF&TF ")); miList.add(new ProductorTierraFertil(" TF-051 ","TORRES PAREDES SEGUNDO MIGUEL ","PROGRESO&EL PROGRESO&ROSA ELVIRA DOS LOTES "," PALESTINA-EL GUABO&PALESTINA-EL GUABO&PALESTINA-LA IBERIA-EL GUABO "," 2,14&5,33&5,26 "," 107&267&263 "," MAYACERT&MAYACERT&MAYACERT "," 4056186457349 "," 03474&10697&04133 "," 0985704849 "," TF&TF&E ")); miList.add(new ProductorTierraFertil(" TF-127 ","VALENCIA ALVARADO WILIAN NEPTALI ","TIFANY "," PALENQUE-PASAJE "," 6,00 "," 260,00 "," QCS "," 4059883482218 "," 08106 "," 0969216031 "," IND ")); miList.add(new ProductorTierraFertil(" TF-023 ","VILLACIS VILLACIS CESAR ALBERTO ","SAN LUIS "," EL SAUCE - EL GUABO "," 6,00 "," 276,00 "," MAYACERT "," 4052852552004 "," 102728 "," 0967843652 "," TF ")); miList.add(new ProductorTierraFertil(" TF-081 ","VISCAINO ZUMBA LUIS ALVINO ","SAN LUIS&CHOCOANO "," LA PEAÑA-PASAJE&LA PEAÑA-PASAJE "," 5,49&1,44 "," 291&69 "," MAYACERT&MAYACERT "," 4056186457356 "," 07201/07231/101320&02951 "," 0994263179 "," E ")); miList.add(new ProductorTierraFertil(" TF-178 ","ZHINDON CHUYA DIANA PAOLA "," SAN JORGE "," LA PEAÑA-PASAJE "," 5,90 "," 289,00 "," MAYACERT "," 4056186685438 "," S/N "," 0969059992 "," E ")); miList.add(new ProductorTierraFertil(" TF-083 ","ZHINDON CHUYA IRMA DEL ROCIO "," LA MALDONADO&EL SAUCE "," JUANA DE ORO - PASAJE&JESUS DEL BUEN PASTOR - PASAJE "," 1,6&1,6 "," 67&69 "," MAYACERT&MAYACERT "," 4056186685445 "," N21059&N21060 "," 0969059995 "," E&E "));
        RealtimDatabase.initDatabasesRootOnly();

        DatabaseReference miref=RealtimDatabase.rootDatabaseReference.child("Productores").child("todosLosProductores");


        Log.i("miliserr","el size de lista es "+miList.size());

        for(ProductorTierraFertil productores: miList){

            miref.push().setValue(productores);

        }



    }


}
