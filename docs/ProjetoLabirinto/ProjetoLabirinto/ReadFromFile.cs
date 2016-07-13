using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLabirinto
{
    class ReadFromFile
    {
        public List<Aresta> read() {

            List<Aresta> lista = new List<Aresta>();
            string[] lines = File.ReadAllLines(@"D:\entrada.txt");

            
            foreach (string line in lines)
            {
                var linha = line.Split(' ');
                lista.Add(new Aresta() {
                    VerticeOrigem = Convert.ToInt32(linha[0]),
                    VerticeDestino = Convert.ToInt32(linha[1]),
                    Peso = Convert.ToInt32(linha[2]) });
            }
            return lista;
        }
    }
}
