# UT6_PD7

EJERCICIO 1 

Investiga cómo está implementado el método hashCode en Java para objetos de la clase Object. 
Luego investiga cómo se implementa el mismo para las clases Integer y String. Explica por qué la 
implementación es diferente. 

'hashCode' en la clase 'Object'

    public native int hashCode();


'hashCode' en la clase 'Integer'

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    public static int hashCode(int value) {
        return value;
    }

'hashCode' en la clase 'String'

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

¿Por qué son diferentes estas implementaciones?



EJERCICIO 2 

Investiga y diagrama cómo son las estructuras internas de un HashMap. Con lo investigado en el 
ejercicio anterior, diagrama el estado de las estructuras luego de insertar las siguientes strings: 

    • Hola 
    • HolaMundo 
    • HashMap 
    • Colecciones 

Paso 1: Calculamos el código hash de cada string y luego determinamos el índice del bucket donde se almacenará cada string. Suponiendo que el tamaño inicial del array de buckets es 16, el índice se calcula con la fórmula (hash & (n - 1)), donde hash es el código hash y n es el tamaño del array.

Paso 2: Calculamos los codigos para los strings y determinar su indice:

"Hola" tiene un hash de 2317616 y se asigna al índice 0.
"HolaMundo" tiene un hash de 1214198418 y se asigna al índice 2.
"HashMap" tiene un hash de 69609650 y se asigna al índice 2.
"Colecciones" tiene un hash de -1644051683 y se asigna al índice 13.

Diagrama de la estructura del HashMap

    Buckets (size 16)
    Index | Node (Entry)
    0     | [ "Hola" -> null ]
    1     | null
    2     | [ "HolaMundo" -> "HashMap" -> null ]
    3     | null
    4     | null
    5     | null
    6     | null
    7     | null
    8     | null
    9     | null
    10    | null
    11    | null
    12    | null
    13    | [ "Colecciones" -> null ]
    14    | null
    15    | null
