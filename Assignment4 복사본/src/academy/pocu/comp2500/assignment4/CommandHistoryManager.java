package academy.pocu.comp2500.assignment4;

import java.util.Stack;

public class CommandHistoryManager {
    private StatusCanvas status = new StatusCanvas();
    private Canvas canvas;
    private Stack<ICommand> undoComments = new Stack<>();
    private Stack<ICommand> redoComments = new Stack<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand commend) {
        boolean execute = commend.execute(this.canvas);

        if (execute) {
            undoComments.push(commend);
            redoComments.clear();
        }

        return execute;
    }

    public boolean canUndo() {
        return undoComments.empty() == false;
    }

    public boolean canRedo() {
        return redoComments.empty() == false;
    }

    public boolean undo() {
        if (undoComments.size() > 0) {
            ICommand commend = undoComments.pop();
            commend.undo();
            redoComments.push(commend);
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (redoComments.size() > 0) {
            ICommand redo = redoComments.pop();
            redo.redo();
            undoComments.push(redo);
            return true;
        }
        return false;
    }

}
