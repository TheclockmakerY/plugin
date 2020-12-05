package fr.tclk.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandtest implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String message, String[] arg3)
    {
        sender.sendMessage("bravo, tu as réussi !!!");

        return false;
    }

}
