﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLabirinto
{
    public class Grafo
    {
        
            Dictionary<int, Dictionary<int, int>> vertices = new Dictionary<int, Dictionary<int, int>>();

            public void addVertice(int name, Dictionary<int, int> edges)
            {
                vertices[name] = edges;
            }

            public List<int> menorCaminho(int inicio, int final)
            {
                var proximo = new Dictionary<int, int>();
                var distancias = new Dictionary<int, int>();
                var nodes = new List<int>();

                List<int> path = null;
           

                foreach (var vertice in vertices)
                {
                    if (vertice.Key == inicio)
                    {
                        distancias[vertice.Key] = 0;
                    }
                    else
                    {
                        distancias[vertice.Key] = int.MaxValue;
                    }

                    nodes.Add(vertice.Key);
                }

                while (nodes.Count != 0)
                {
                    nodes.Sort((x, y) => distancias[x] - distancias[y]);

                    var menor = nodes[0];
                    nodes.Remove(menor);

                    if (menor == final)
                    {
                        path = new List<int>();
                        while (proximo.ContainsKey(menor))
                        {
                            path.Add(menor);
                            menor = proximo[menor];
                        }

                        break;
                    }

                    if (distancias[menor] == int.MaxValue)
                    {
                        break;
                    }

                    foreach (var vizinho in vertices[menor])
                    {
                        var alt = distancias[menor] + vizinho.Value;
                        if (alt < distancias[vizinho.Key])
                        {
                            distancias[vizinho.Key] = alt;
                            proximo[vizinho.Key] = menor;
                        }
                    }
                }
                return path;
            }
        }
}
