package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {
//    private Canvas canvas;
//    private ArrayList<ICommand> commands;
//    private int commandIndex;
//
//    public CommandHistoryManager(Canvas canvas) {
//        this.canvas = canvas;
//        this.commands = new ArrayList<ICommand>();
//        commandIndex = -1;
//    }
//
//    public boolean execute(ICommand command) {
//        if (command.execute(canvas)) {
//            commandIndex += 1;
//
//            commands.subList(commandIndex, commands.size()).clear();
//            commands.add(command);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean canUndo() {
//        if (commandIndex < 0) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public boolean canRedo() {
//        if (this.commands.size() == 0) {
//            return false;
//        }
//
//        if (commandIndex == this.commands.size() - 1) {
//            return false;
//        }
//
//        return false;
//    }
//
//    public boolean undo() {
//        if (commandIndex < 0) {
//            return false;
//        }
//
//        if (this.commands.get(this.commandIndex).undo()) {
//            this.commandIndex -= 1;
//
//        }
//        return true;
//    }
//
//    public boolean redo() {
//        if (this.commands.size() == 0) {
//            return false;
//        }
//
//        if (commandIndex == this.commands.size() - 1) {
//            return false;
//        }
//
//        this.commandIndex += 1;
//
//        if (this.commands.get(this.commandIndex).redo()) {
//
//        } else {
//            this.commandIndex -= 1;
//        }
//        return true;
//    }
//    private StatusCanvas status = new StatusCanvas();
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
