package com.readme.logic.services.readme;

public class ReadmeParam implements Comparable<ReadmeParam> {
    private int line;
    private final String paramName;
    private final String paramType;
    private final String paramLabel;

    public ReadmeParam(String paramDetected) {
        String[] split = paramDetected.split("\\$");

        if (split.length < 3) {
            throw new IllegalArgumentException("The param passed must be devided by 3 parts");
        }

        this.paramName = split[1];
        this.paramType = split[2];
        this.paramLabel = split[3];
    }

    public ReadmeParam(String paramDetected, int line) {
        this(paramDetected);
        this.line = line;
    }
    @Override
    public int compareTo(ReadmeParam o) {
        return this.paramName.compareTo(o.paramName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadmeParam that = (ReadmeParam) o;

        return this.paramName.equals(that.paramName) && this.paramType.equals(that.paramType);
    }

    @Override
    public int hashCode() {
        int result = paramName.hashCode();
        result = 31 * result + paramType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReadmeParam{" +
                "line=" + line +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                ", paramLabel='" + paramLabel + '\'' +
                '}';
    }
}
