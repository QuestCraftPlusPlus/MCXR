package net.sorenon.mcxr.play.gui.keyboard;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

public abstract class XrAbstract2DKeyboard {

    // All the charsets available
    private final char[][] defaultCharset;
    private final char[][] shiftCharset;
    private final char[][] capsCharset;

    // Static method used to remove a character from the end of a string
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

    public XrAbstract2DKeyboard() {

        // In this constructor we will use the querty charset by default
        defaultCharset = new char[][] {
                new char[] {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', '\b'},
                new char[] {'\t', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\'},
                new char[] {'\f', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'', '\r'},
                new char[] {'■','\n','■', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'},
                new char[] {' '}
        };

        capsCharset = new char[][] {
                new char[] {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', '\b'},
                new char[] {'\t', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'},
                new char[] {'\f', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', '\r'},
                new char[] {'■','\n','■', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'},
                new char[] {' '}
        };

        shiftCharset = new char[][] {
                new char[] {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '\b'},
                new char[] {'\t', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|'},
                new char[] {'\f', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '\"', '\r'},
                new char[] {'■','\n','■', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'},
                new char[] {' '}
        };

    }

    public XrAbstract2DKeyboard(char[][] defaultCharset, char[][] shiftCharset, char[][] capsCharset) {

        // This constructor allows us to use any charset that we want.
        this.defaultCharset = defaultCharset;
        this.shiftCharset = shiftCharset;
        this.capsCharset = capsCharset;

    }

    public void renderKeyboard(char[][] charset, int width, int height, int buttonwidth) {

        int rowindex = 1;

        for (char[] row : charset) {

            // this Nested Loop will go through all the buttons in each row
            for (int i=0; i < row.length; i++) {

                // Get the placement for this button
                int buttonX = ((width / 2) - 8 * buttonwidth) + buttonwidth * (i+1);
                int buttonY = (height / 5) + (buttonwidth * rowindex);
                char character = row[i];

                Button key =  switch (character) {

                    case '\r' ->
                        new Button(buttonX, buttonY, buttonwidth * 2, 20,
                                new TranslatableComponent("Enter"),
                            this::returnButton);
                    case '\b' ->
                        new Button(buttonX, buttonY, buttonwidth, 20,
                                new TranslatableComponent("Bksp"),
                            this::backSpaceButton);
                    case ' ' ->
                        new Button(buttonX + 150, buttonY, buttonwidth + 100, 20,
                                new TranslatableComponent("Space"),
                            this::spaceButton);
                    case '\t' ->
                        new Button(buttonX, buttonY, buttonwidth, 20,
                                new TranslatableComponent("Tab"),
                            this::tabButton);
                    case '\n' ->
                        new Button(buttonX, buttonY, buttonwidth * 2, 20,
                                new TranslatableComponent("Shift"),
                            this::shiftButton);
                    case '\f' ->
                        new Button(buttonX, buttonY, buttonwidth, 20,
                                new TranslatableComponent("Caps"),
                            this::capsButton);
                    default ->
                        new Button(buttonX, buttonY, buttonwidth, 20,
                                new TranslatableComponent(Character.toString(character)),
                            this::letterButton);

                };

                key.visible = !(character == '■');

                this.renderKey(key);

            }

            rowindex ++;
        }

        this.afterRender(); // this isn't a good idea, but I don't feel like testing a better solution
    }

    public void spaceButton(Button button) {}

    public void tabButton(Button button) {}

    public void shiftButton(Button button) {}

    public void capsButton(Button button) {}

    public void afterRender() {}

    public void renderKey(Button key) {}

    public void letterButton(Button instance) {}

    public void returnButton(Button instance) {}

    public void backSpaceButton(Button instance) {}

    public char[][] getDefaultCharset() {
        return defaultCharset;
    }

    public char[][] getCapsCharset() {
        return capsCharset;
    }

    public char[][] getShiftCharset() {
        return shiftCharset;
    }
}
