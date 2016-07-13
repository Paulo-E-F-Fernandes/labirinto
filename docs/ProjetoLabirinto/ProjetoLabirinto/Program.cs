using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLabirinto
{
    class Program
    {
        static void Main(string[] args)
        {
            Grafo g = new Grafo();
            g.addVertice(0, new Dictionary<int, int>() { { 1, 1 } });
            g.addVertice(1, new Dictionary<int, int>() { { 0, 1 }, { 2, 1 } , { 3, 2 }, { 4, 2 } });
            g.addVertice(2, new Dictionary<int, int>() { { 1, 1 } });
            g.addVertice(3, new Dictionary<int, int>() { { 1, 2 }, { 4, 6 }, { 5, 1 } });
            g.addVertice(4, new Dictionary<int, int>() { { 1, 2 }, { 3, 6 } });
            g.addVertice(5, new Dictionary<int, int>() { { 1, 8 } });
            
            g.menorCaminho(1, 5).ForEach(x => Console.WriteLine(x));
            Console.Read();
            //listBox.Width = this.Width;
            //listBox.Height = this.Height;
            //this.Controls.Add(listBox);
        }

    }
}

