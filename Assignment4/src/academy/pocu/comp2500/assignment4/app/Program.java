package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();


            Canvas canvasaa = new Canvas(10, 10);
            System.out.println(canvasaa.getDrawing());
            canvasaa.fillVerticalLine(0, 'g');
            System.out.println(canvasaa.getDrawing());

        OverdrawAnalyzer canvas = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(canvas);
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        manager.execute(new IncreasePixel(3, 1)); // 1
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new IncreasePixel(1, 3));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.undo();
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DrawPixel(4, 4, 'p'));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new FillVericalLine(3, 'Z')); // 1
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ToUpper(0, 4));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new IncreasePixel(4, 3));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DecreasePixel(3, 2));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DrawPixel(1, 4, '?'));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new FillVericalLine(2, (char)0x5C));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DrawPixel(3, 2, 'w'));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ToUpper(0, 0));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DecreasePixel(4, 1));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ToLower(1, 2));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new DrawPixel(1, 3, '+'));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ToLower(2, 3));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ToLower(3, 1)); // 1
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.undo();                             // 1
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new ClearCanvas());         // 1
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());
//        manager.execute(new IncreasePixel(4, 2));
//        System.out.println(canvas.getOverdrawCount(3, 1));
//        System.out.println(canvas.getDrawing());



//
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new DrawPixel(4,4,'a'));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new ToLower(0,0));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new DrawPixel(2,4,'n'));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.redo();
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new Clear());
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new DecreasePixel(4, 3));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new ToUpper(3, 0));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new IncreasePixel(3, 0));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.redo();
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new Clear());
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new FillVerticalLine(0, 'g')); // 1
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new FillVerticalLine(3, 'A'));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new DecreasePixel(2,0));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new ToLower(1, 2));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new Clear()); // 2
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.redo();
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new FillHorizontalLine(1, 'J'));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new ToLower(4, 1));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.execute(new ToUpper(0, 2));
//        System.out.println(canvas.getOverdrawCount(0, 0));
//        manager.undo();
//        System.out.println(canvas.getOverdrawCount(0, 0));
    }
}
