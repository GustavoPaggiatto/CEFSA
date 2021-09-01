using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace N1BIM1
{
    class Program
    {
        const int fZero = 600; // RA: 082180006.

        const double omgZero = 2 * Math.PI * fZero; // Ômega Zero.

        const double intervalo = 0.001; //Intervalo de tempo.

        const int repeticoes = 10000; // Quantidade de loops efetuados.

        const int qtdTrigonometricos = 4; // Quantidade de termos trigonométricos da função em questão.

        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Magenta;

            Console.WriteLine("************** N1 BIM1 - EC7 **************");
            Console.WriteLine();

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Aguarde, o cálculo está sendo efetuado...");
            Console.WriteLine("Dados:");
            Console.WriteLine("F Zero: " + fZero + " Hz.");
            Console.WriteLine("Ômega Zero: " + omgZero + " rad/s");

            var grafico = new Dictionary<double, double>();
            double tempo = 0;

            for (int i = 0; i < repeticoes; i++)
            {
                double y = 0.5;
                double trigonometricos = 0;

                for (int n = 1; n <= qtdTrigonometricos; n += 2)
                {
                    trigonometricos +=
                        Math.Sin(tempo * omgZero) * 1 / n;
                }

                y += 2 * trigonometricos / Math.PI;

                grafico.Add(tempo, y);
                tempo += intervalo;
            }

            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("Finalizando (excrevendo coordenadas)...");

            using (StreamWriter writer = new StreamWriter("cartesiano.txt", false, Encoding.Default))
            {
                foreach (var key in grafico.Keys)
                    writer.WriteLine("t = " + key + "; f(t) = " + grafico[key]);
            }

            Console.WriteLine("Arquivo com as coordenadas escrito");
            Console.WriteLine("Pressione qualquer tecla para sair");
            Console.ReadKey();
        }
    }
}
