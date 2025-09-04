package models;

public enum Colour {
        WHITE, BLACK;

        public Colour opposite() {
            return this == BLACK ? WHITE : BLACK;
        }
}
