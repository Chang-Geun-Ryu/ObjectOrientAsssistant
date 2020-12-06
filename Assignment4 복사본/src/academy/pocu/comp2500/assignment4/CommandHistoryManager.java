package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private final Canvas canvas;
    private ArrayList<ICommand> appliedCommands;
    private ArrayList<ICommand> undoidCommands;
    private final ArrayList<ICommand> commands;
    private final ArrayList<ICommand> undidCommands;


    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
        this.appliedCommands = new ArrayList<>();
        this.undoidCommands = new ArrayList<>();

        this.commands = new ArrayList<>();
        this.undidCommands = new ArrayList<>();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private ICommand getRecentAppliedCommand() {
        return this.appliedCommands.get(appliedCommands.size() - 1);
    }

    private ICommand getRecentUndidCommand() {
        return this.undoidCommands.get(undoidCommands.size() - 1);
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            this.appliedCommands.add(command);
            this.undoidCommands.clear();
            return true;
        }
        return false;
    }

    public boolean canUndo() {
        if (this.appliedCommands.size() == 0) {
            return false;
        }
        Command command = (Command) this.getRecentAppliedCommand();
        return command.isUndoable();
    }

    public boolean canRedo() {
        if (this.undoidCommands.size() == 0) {
            return false;
        }
        return true;
//        Command command = (Command) this.getRecentAppliedCommand();
//        return command.isRedoable();
    }

    public void removeAppliedCommand(ICommand command) {
        this.appliedCommands.remove(command);
    }

    public void removeUndioidCommand(ICommand command) {
        this.undoidCommands.remove(command);
    }

    public boolean undo() {
        if (this.canUndo() && this.getRecentAppliedCommand().undo()) {
            this.undoidCommands.add(this.getRecentAppliedCommand());
            this.removeAppliedCommand(this.getRecentAppliedCommand());
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (this.canRedo() && this.getRecentUndidCommand().redo()) {
            this.appliedCommands.add(this.getRecentUndidCommand());
            this.removeUndioidCommand(this.getRecentUndidCommand());
            return true;
        }
        return false;
    }


}
