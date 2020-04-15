package org.uma.mbd.mdRectas;

        import org.uma.mbd.mdRectas.rectas.Punto;
        import org.uma.mbd.mdRectas.rectas.Recta;
        import org.uma.mbd.mdRectas.rectas.Segmento;
        import org.uma.mbd.mdRectas.rectas.Vector;

public class Main {
    public static void main (String[] args) {
        Punto pto = new Punto(1,-2);
        pto.trasladar(1, 4);
        System.out.println(pto);

        Punto pto1 = new Punto(1,-3);

        Segmento s = new Segmento (pto,pto1);
        System.out.println(s.longitud());
        System.out.println(s);

        Vector v = new Vector(3, 6);
        Vector vo = v.ortogonal();
        System.out.println(v);
        System.out.println(vo);
        System.out.println(vo.modulo());

        Recta r = new Recta(new Punto (2,3), new Punto (-1,2));
        Recta r2 = r.perpendicularPor (new Punto (4,4));
        Punto pi = r.interseccionCon(r2);

        System.out.println(r);
        System.out.println(r2);
        System.out.println(pi);
        System.out.println(r.paralelaPor(new Punto(3,4)));

    }
}
