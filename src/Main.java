import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean wanna_continue = true;
      while (wanna_continue)
      {
          boolean petla = false;
          int i=0;
          int wynik=0;
          while(i==0 || petla)
          {
              System.out.println("Wybierz rodzaj operacji na którą chcesz wykonać: ");
              System.out.println("Dodawanie:1");
              System.out.println("Odejmowanie:2");
              System.out.println("Mnożenie:3");
              System.out.println("Wartość w punkcie danego wielomianu:4");
              Scanner scanner = new Scanner(System.in);
              i+=1;
              try{
                  wynik = scanner.nextInt();
              }
              catch (NumberFormatException | InputMismatchException e)
              {
                  System.out.println("Wpisano niewłaściwą komendę");
                  petla=true;
              }
              if(wynik<1 || wynik>4)
              {
                  System.out.println("Wpisano niewłaściwą komendę");
                  petla=true;
              }
          }
          if(wynik==1)
          {
              System.out.println("Wpisz pierwszy wielomain:");
              Scanner scanner = new Scanner(System.in);
              //System.out.println(scanner.nextLine());
              Polynomial polynomial = new Polynomial(scanner.nextLine());
              System.out.println("Wpisz drugi wielomain:");
              Scanner scanner1 = new Scanner(System.in);
              Polynomial polynomial1 = new Polynomial(scanner1.nextLine());
              double [] tab =polynomial.add(polynomial1.tab);
              for(int j=0;j< tab.length;j++)
              {
                  if(tab[j]!=0)
                  {
                      System.out.print(tab[j]+"x^"+j+",");
                  }
              }
          }
          else if(wynik==2)
          {
              System.out.println("Wpisz pierwszy wielomain:");
              Scanner scanner = new Scanner(System.in);
              Polynomial polynomial = new Polynomial(scanner.nextLine());
              System.out.println("Wpisz drugi wielomain:");
              Scanner scanner1 = new Scanner(System.in);
              Polynomial polynomial1 = new Polynomial(scanner1.nextLine());
              double [] tab =polynomial.sub(polynomial1.tab);
              int z=0;
              for(int j=0;j< tab.length;j++)
              {
                  if(tab[j]!=0)
                  {
                      System.out.print(tab[j]+"x^"+j+",");
                  }
                  else {
                      z+=1;
                  }
                  if(z== tab.length-1)
                  {
                      System.out.println("Wynik to "+0);
                  }
              }
          }
          else if(wynik==3)
          {
              System.out.println("Wpisz pierwszy wielomain:");
              Scanner scanner = new Scanner(System.in);
              Polynomial polynomial = new Polynomial(scanner.nextLine());
              System.out.println("Wpisz drugi wielomain:");
              Scanner scanner1 = new Scanner(System.in);
              Polynomial polynomial1 = new Polynomial(scanner1.nextLine());
              double [] tab =polynomial.mul(polynomial1.tab);
              for(int j=0;j< tab.length;j++)
              {
                  if(tab[j]!=0)
                  {
                      System.out.print(tab[j]+"x^"+j+",");
                  }
              }
          }
          else if(wynik==4)
          {
              System.out.println("Wpisz wielomain:");
              Scanner scanner = new Scanner(System.in);
              Polynomial polynomial = new Polynomial(scanner.nextLine());
              System.out.println("Wpisz wartosc x:");
              Scanner scanner1 = new Scanner(System.in);
              double horner=polynomial.horner(scanner1.nextDouble());
              System.out.println("Wynik algorytmu hornera to: "+horner);
          }
          System.out.println("Czy chcesz kontynuować ?/ tak/ nie ");
          Scanner scanner = new Scanner(System.in);
          String in = scanner.nextLine();
          if(in.equals("nie") || !in.equals("tak")) {
              wanna_continue = false;
          }
      }

    }
}