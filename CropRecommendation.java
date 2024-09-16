import java.util.ArrayList;
import java.util.Scanner;

public class CropRecommendation
{
    public static void main(String[] args) {

        ArrayList<Plant> plants = new ArrayList<>();

        Rice r = new Rice();
        Maize ma = new Maize();
        Chickpea c = new Chickpea();
        KidneyBeans kb = new KidneyBeans();
        PigeonBeans pb = new PigeonBeans();
        MothBeans mb = new MothBeans();
        MungBean mgb = new MungBean();
        BlackGram bg = new BlackGram();
        Cotton co = new Cotton();
        Jute j = new Jute();
        Pomegranate p = new Pomegranate();
        Banana b = new Banana();

        

        plants.add(r);
        plants.add(ma);
        plants.add(c);
        plants.add(kb);
        plants.add(pb);
        plants.add(mb);
        plants.add(mgb);
        plants.add(bg);
        plants.add(co);
        plants.add(j);
        plants.add(p);
        plants.add(b);

         
            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want:");
            System.out.println("1.Crop recommendation");
            System.out.println("2.Plant details:");
            System.out.print("\nEnter your choice : ");
            int choice = sc.nextInt();

            while(true){
                switch(choice)
                {
                    case 1:
                        crop_recommendation(plants);
                        break;
                    case 2:
                        System.out.println("\nList of Available plants : ");

                        for(int i = 0;i < plants.size();i++){
                            System.out.println((i+1) + "."+plants.get(i).getClass().getSimpleName());
                        }

                        System.out.print("\nEntre your choice : ");
                        int ch = sc.nextInt();

                        crop_details(plants.get(ch-1));
                        break;
                    default:
                        System.out.println("Invalid choice!!");
                        System.exit(0);
                }
            }
        }
    

    public static void crop_details(Plant p){

       System.out.println("\nPlant name : " + p.getClass().getSimpleName());

        System.out.println("\nNitrogen range : ["+ p.getNitrogenLower() + " - " + p.getNitrogenUpper() + "]");
        System.out.println("Phosphorous range ["+ p.getPhosphorousLower() + " - " + p.getNitrogenUpper() + "]");
        System.out.println("Potassium range : ["+ p.getPotassiumLower() + " - " + p.getPotassiumUpper() + "]");
        System.out.println("Temperature range : ["+ p.getTemperatureLower() + " - " + p.getTemperatureUpper() + "]");
        System.out.println("Humidity range : ["+ p.getHumidityLower() + " - " + p.getHumidityUpper() + "]");
        System.out.println("PH range : ["+ p.getPhLower() + " - " + p.getPhUpper() + "]");
        System.out.println("Rainfall range : ["+ p.getRainfallLower() + " - " + p.getRainfallUpper() + "]");
        System.exit(0);
    }
    public static void crop_recommendation(ArrayList<Plant> plants)
    {

        try (Scanner sc = new Scanner(System.in)) {
            double N;
            double P;
            double K;
            double temp;
            double hum;
            double ph;
            double rain;

            System.out.println("\nEnter the following soil details : \n");

            System.out.print("Nitrogen : ");
            N = sc.nextDouble();
            System.out.print("Phosphorous : ");
            P = sc.nextDouble();
            System.out.print("Potassium : ");
            K = sc.nextDouble();
            System.out.print("Temperature : ");
            temp = sc.nextDouble();
            System.out.print("Humidity : ");
            hum = sc.nextDouble();
            System.out.print("pH: ");
            ph = sc.nextDouble();
            System.out.print("Rainfall : ");
            rain = sc.nextDouble();


            ArrayList<Plant> recommendedPlants = new ArrayList<>();

            for(int i = 0;i< plants.size();i++)
            {
                Plant o = plants.get(i);

                if(intervalCheck(N,o.getNitrogenLower(),o.getNitrogenUpper()))
                    if(intervalCheck(P,o.getPhosphorousLower(),o.getPhosphorousUpper()))
                        if(intervalCheck(K,o.getPotassiumLower(),o.getPotassiumUpper()))
                            if(intervalCheck(temp,o.getTemperatureLower(),o.getTemperatureUpper()))
                                if(intervalCheck(hum,o.getHumidityLower(),o.getHumidityUpper()))
                                    if(intervalCheck(ph,o.getPhLower(), o.getPhUpper()))
                                        if(intervalCheck(rain,o.getRainfallLower(),o.getRainfallUpper()))
                                            recommendedPlants.add(o);
            }

            if(recommendedPlants.size() == 0)
            {
                System.out.println("\nRecommended plants : NONE");
            }
            else {
                System.out.println("\nList of recommended plants");

                for (int i = 0; i < recommendedPlants.size(); i++) 
                {
                    Plant o = recommendedPlants.get(i);
                    System.out.println((i+1) + "." + o.getClass().getSimpleName());
                }
            }
        }

        System.exit(0);
    }
    public static boolean intervalCheck(double ele,double min,double max)
    {
        if(ele>=min && ele<=max)
            return true;
        else
            return false;
    }
}

abstract class Plant
{
    abstract double getNitrogenUpper();
    abstract double getNitrogenLower();
    abstract double getPotassiumUpper();
    abstract double getPotassiumLower();
    abstract double getPhosphorousUpper();
    abstract double getPhosphorousLower();
    abstract double getTemperatureUpper();
    abstract double getTemperatureLower();
    abstract double getHumidityUpper();
    abstract double getHumidityLower();
    abstract double getPhUpper();
    abstract double getPhLower();
    abstract double getRainfallUpper();
    abstract double getRainfallLower();

}
class Rice extends Plant
{

    double getNitrogenUpper()
    {
        return 99.0;
    }
    double getNitrogenLower()
    {
        return 60.0;
    }
    double getPotassiumUpper()
    {
        return 45.0;
    }
    double getPotassiumLower()
    {
        return 35.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 26.9299;
    }
    double getTemperatureLower()
    {
        return 20.0454;
    }
    double getHumidityUpper()
    {
        return 86.9690;
    }
    double getHumidityLower()
    {
        return 80.1226;
    }
    double getPhUpper()
    {
        return 7.8684;
    }
    double getPhLower()
    {
        return 5.0053;
    }
    double getRainfallUpper()
    {
        return 298.5601;
    }
    double getRainfallLower()
    {
        return 182.5616;
    }
}
class Maize extends Plant
{
    double getNitrogenUpper()
    {
        return 100.0;    }
    double getNitrogenLower()
    {
        return 60.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 25.5498;
    }
    double getTemperatureLower()
    {
        return 18.0418;
    }
    double getHumidityUpper()
    {
        return 74.8491;
    }
    double getHumidityLower()
    {
        return 55.2822;
    }
    double getPhUpper()
    {
        return 6.9958;
    }
    double getPhLower()
    {
        return 5.5136;
    }
    double getRainfallUpper()
    {
        return 109.7515;
    }
    double getRainfallLower()
    {
        return 60.6517;
    }
}
class Chickpea extends Plant
{
    double getNitrogenUpper()
    {
        return 83.0;
    }
    double getNitrogenLower()
    {
        return 20;
    }
    double getPotassiumUpper()
    {
        return 85.0;
    }
    double getPotassiumLower()
    {
        return 19.0;
    }
    double getPhosphorousUpper()
    {
        return 80.0;
    }
    double getPhosphorousLower()
    {
        return 55.0;
    }
    double getTemperatureUpper()
    {
        return 25.7304;
    }
    double getTemperatureLower()
    {
        return 17.0249;
    }
    double getHumidityUpper()
    {
        return 70.7473;
    }
    double getHumidityLower()
    {
        return 14.2580;
    }
    double getPhUpper()
    {
        return 8.8687;
    }
    double getPhLower()
    {
        return 5.9889;
    }
    double getRainfallUpper()
    {
        return 98.7377;
    }
    double getRainfallLower()
    {
        return 65.1136;
    }
}
class KidneyBeans extends Plant
{
    double getNitrogenUpper()
    {
        return 40.0;
    }
    double getNitrogenLower()
    {
        return 0.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 80.0;
    }
    double getPhosphorousLower()
    {
        return 55.0;
    }
    double getTemperatureUpper()
    {
        return 24.9236;
    }
    double getTemperatureLower()
    {
        return 15.3304;
    }
    double getHumidityUpper()
    {
        return 24.9696;
    }
    double getHumidityLower()
    {
        return 18.0922;
    }
    double getPhUpper()
    {
        return 5.9981;
    }
    double getPhLower()
    {
        return 5.5029;
    }
    double getRainfallUpper()
    {
        return 149.7441;
    }
    double getRainfallLower()
    {
        return 60.2755;
    }
}
class PigeonBeans extends Plant
{
    double getNitrogenUpper()
    {
        return 40.0;
    }
    double getNitrogenLower()
    {
        return 0.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 80.0;
    }
    double getPhosphorousLower()
    {
        return 55.0;
    }
    double getTemperatureUpper()
    {
        return 36.9779;
    }
    double getTemperatureLower()
    {
        return 18.3191;
    }
    double getHumidityUpper()
    {
        return 69.6914;
    }
    double getHumidityLower()
    {
        return 20.2476;
    }
    double getPhUpper()
    {
        return 7.4454;
    }
    double getPhLower()
    {
        return 4.5482;
    }
    double getRainfallUpper()
    {
        return 198.8289;
    }
    double getRainfallLower()
    {
        return 90.0542;
    }
}
class MothBeans extends Plant
{
    double getNitrogenUpper()
    {
        return 40.0;
    }
    double getNitrogenLower()
    {
        return 0.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 31.9992;
    }
    double getTemperatureLower()
    {
        return 24.0182;
    }
    double getHumidityUpper()
    {
        return 64.9558;
    }
    double getHumidityLower()
    {
        return 40.0093;
    }
    double getPhUpper()
    {
        return 9.9350;
    }
    double getPhLower()
    {
        return 3.5047;
    }
    double getRainfallUpper()
    {
        return 74.4433;
    }
    double getRainfallLower()
    {
        return 30.9201;
    }
}
class MungBean extends Plant
{
    double getNitrogenUpper()
    {
        return 40.0;
    }
    double getNitrogenLower()
    {
        return 0.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 29.9145;
    }
    double getTemperatureLower()
    {
        return 27.0147;
    }
    double getHumidityUpper()
    {
        return 89.9961;
    }
    double getHumidityLower()
    {
        return 80.0349;
    }
    double getPhUpper()
    {
        return 7.1994;
    }
    double getPhLower()
    {
        return 6.2189;
    }
    double getRainfallUpper()
    {
        return 59.8743;
    }
    double getRainfallLower()
    {
        return 36.1204;
    }
}
class BlackGram extends Plant
{
    double getNitrogenUpper()
    {
        return 60.0;
    }
    double getNitrogenLower()
    {
        return 32.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 80.0;
    }
    double getPhosphorousLower()
    {
        return 62.0;
    }
    double getTemperatureUpper()
    {
        return 34.9466;
    }
    double getTemperatureLower()
    {
        return 28.0515;
    }
    double getHumidityUpper()
    {
        return 69.9610;
    }
    double getHumidityLower()
    {
        return 63.4980;
    }
    double getPhUpper()
    {
        return 7.753;
    }
    double getPhLower()
    {
        return 6.2676;
    }
    double getRainfallUpper()
    {
        return 74.9155;
    }
    double getRainfallLower()
    {
        return 43.3579;
    }
}
class Cotton extends Plant
{
    double getNitrogenUpper()
    {
        return 140.0;
    }
    double getNitrogenLower()
    {
        return 100.0;
    }
    double getPotassiumUpper()
    {
        return 25.0;
    }
    double getPotassiumLower()
    {
        return 15.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 25.9923;
    }
    double getTemperatureLower()
    {
        return 22.0008;
    }
    double getHumidityUpper()
    {
        return 84.8766;
    }
    double getHumidityLower()
    {
        return 75.0053;
    }
    double getPhUpper()
    {
        return 7.9946;
    }
    double getPhLower()
    {
        return 5.8010;
    }
    double getRainfallUpper()
    {
        return 99.9310;
    }
    double getRainfallLower()
    {
        return 60.6538;
    }
}
class Jute extends Plant
{
    double getNitrogenUpper()
    {
        return 100.0;
    }
    double getNitrogenLower()
    {
        return 60.0;
    }
    double getPotassiumUpper()
    {
        return 45.0;
    }
    double getPotassiumLower()
    {
        return 35.0;
    }
    double getPhosphorousUpper()
    {
        return 60.0;
    }
    double getPhosphorousLower()
    {
        return 35.0;
    }
    double getTemperatureUpper()
    {
        return 26.9858;
    }
    double getTemperatureLower()
    {
        return 23.0943;
    }
    double getHumidityUpper()
    {
        return 89.8910;
    }
    double getHumidityLower()
    {
        return 70.8825;
    }
    double getPhUpper()
    {
        return 7.4880;
    }
    double getPhLower()
    {
        return 6.0025;
    }
    double getRainfallUpper()
    {
        return 199.8362;
    }
    double getRainfallLower()
    {
        return 150.2355;
    }
}
class Pomegranate extends Plant
{

    double getNitrogenUpper()
    {
        return 40.0;
    }
    double getNitrogenLower()
    {
        return 0.0;
    }
    double getPotassiumUpper()
    {
        return 45.0;
    }
    double getPotassiumLower()
    {
        return 35.0;
    }
    double getPhosphorousUpper()
    {
        return 30.0;
    }
    double getPhosphorousLower()
    {
        return 5.0;
    }
    double getTemperatureUpper()
    {
        return 24.9627;
    }
    double getTemperatureLower()
    {
        return 18.07132;
    }
    double getHumidityUpper()
    {
        return 94.9989;
    }
    double getHumidityLower()
    {
        return 85.1291;
    }
    double getPhUpper()
    {
        return 7.1995;
    }
    double getPhLower()
    {
        return 5.5618;
    }
    double getRainfallUpper()
    {
        return 112.4750;
    }
    double getRainfallLower()
    {
        return 102.5184;
    }
}
class Banana extends Plant
{

    double getNitrogenUpper()
    {
        return 120.0;
    }
    double getNitrogenLower()
    {
        return 80.0;
    }
    double getPotassiumUpper()
    {
        return 55.0;
    }
    double getPotassiumLower()
    {
        return 45.0;
    }
    double getPhosphorousUpper()
    {
        return 95.0;
    }
    double getPhosphorousLower()
    {
        return 70.0;
    }
    double getTemperatureUpper()
    {
        return 29.9088;
    }
    double getTemperatureLower()
    {
        return 25.0101;
    }
    double getHumidityUpper()
    {
        return 84.9784;
    }
    double getHumidityLower()
    {
        return 75.0319;
    }
    double getPhUpper()
    {
        return 6.4900;
    }
    double getPhLower()
    {
        return 5.5053;
    }
    double getRainfallUpper()
    {
        return 119.8479;
    }
    double getRainfallLower()
    {
        return 90.1097;
    }
}