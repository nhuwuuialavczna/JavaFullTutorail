package DesignPattern.demo.builder;

public class Office {

    private int mCountTable;
    private int mCountChair;
    private int mCountLight;
    private int mCountAir;
    private int mCountFan;

    private Office(Builder builder) {
        mCountTable = builder.mCountTable;
        mCountChair = builder.mCountChair;
        mCountLight = builder.mCountLight;
        mCountAir = builder.mCountAir;
        mCountFan = builder.mCountFan;
    }

    @Override
    public String toString() {
        return mCountAir + "";
    }

    public static class Builder {

        private int mCountTable;
        private int mCountChair;
        private int mCountLight;
        private int mCountAir;
        private int mCountFan;

        public Builder() {

        }

        public Office build() {
            return new Office(this);
        }

        public Builder setTable(int countTable) {
            this.mCountTable = countTable;
            return this;
        }

        public Builder setChair(int countChair) {
            this.mCountChair = countChair;
            return this;
        }

        public Builder setLight(int countLight) {
            this.mCountLight = countLight;
            return this;
        }

        public Builder setAir(int countAir) {
            this.mCountAir = countAir;
            return this;
        }

        public Builder setFan(int countFan) {
            this.mCountFan = countFan;
            return this;
        }

    }
}