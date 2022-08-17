package com.example.common.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 重写 LocalDateTimeDeserializer 类，对传入的 json 字符串日期进行格式化
 */
public class LocalDateTimeDeserializer extends JSR310DateTimeDeserializerBase<LocalDateTime> {
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter DEFAULT_FORMATTER;
    public static final LocalDateTimeDeserializer INSTANCE;

    private LocalDateTimeDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public LocalDateTimeDeserializer(DateTimeFormatter formatter) {
        super(LocalDateTime.class, formatter);
    }

    protected LocalDateTimeDeserializer(LocalDateTimeDeserializer base, Boolean leniency) {
        super(base, leniency);
    }

    protected LocalDateTimeDeserializer withDateFormat(DateTimeFormatter formatter) {
        return new LocalDateTimeDeserializer(formatter);
    }

    protected LocalDateTimeDeserializer withLeniency(Boolean leniency) {
        return new LocalDateTimeDeserializer(this, leniency);
    }

    protected LocalDateTimeDeserializer withShape(JsonFormat.Shape shape) {
        return this;
    }

    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        if (parser.hasTokenId(6)) {
            String string = parser.getText().trim();
            if (string.length() == 0) {
                return !this.isLenient() ? (LocalDateTime) this._failForNotLenient(parser, context, JsonToken.VALUE_STRING) : null;
            } else {
                return convert(string);
            }
        } else {
            if (parser.isExpectedStartArrayToken()) {
                JsonToken t = parser.nextToken();
                if (t == JsonToken.END_ARRAY) {
                    return null;
                }

                LocalDateTime result;
                if ((t == JsonToken.VALUE_STRING || t == JsonToken.VALUE_EMBEDDED_OBJECT) && context.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    result = this.deserialize(parser, context);
                    if (parser.nextToken() != JsonToken.END_ARRAY) {
                        this.handleMissingEndArrayForSingle(parser, context);
                    }

                    return result;
                }

                if (t == JsonToken.VALUE_NUMBER_INT) {
                    int year = parser.getIntValue();
                    int month = parser.nextIntValue(-1);
                    int day = parser.nextIntValue(-1);
                    int hour = parser.nextIntValue(-1);
                    int minute = parser.nextIntValue(-1);
                    t = parser.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        result = LocalDateTime.of(year, month, day, hour, minute);
                    } else {
                        int second = parser.getIntValue();
                        t = parser.nextToken();
                        if (t == JsonToken.END_ARRAY) {
                            result = LocalDateTime.of(year, month, day, hour, minute, second);
                        } else {
                            int partialSecond = parser.getIntValue();
                            if (partialSecond < 1000 && !context.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
                                partialSecond *= 1000000;
                            }

                            if (parser.nextToken() != JsonToken.END_ARRAY) {
                                throw context.wrongTokenException(parser, this.handledType(), JsonToken.END_ARRAY, "Expected array to end");
                            }

                            result = LocalDateTime.of(year, month, day, hour, minute, second, partialSecond);
                        }
                    }

                    return result;
                }

                context.reportInputMismatch(this.handledType(), "Unexpected token (%s) within Array, expected VALUE_NUMBER_INT", new Object[]{t});
            }

            if (parser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                return (LocalDateTime) parser.getEmbeddedObject();
            } else {
                if (parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                    this._throwNoNumericTimestampNeedTimeZone(parser, context);
                }

                return (LocalDateTime) this._handleUnexpectedToken(context, parser, "Expected array or string.", new Object[0]);
            }
        }
    }

    static {
        DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        INSTANCE = new LocalDateTimeDeserializer();
    }

    public LocalDateTime convert(String source) {
        source = source.trim();
        if ("".equals(source)) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            // yyyy-MM
            return LocalDateTime.parse(source + "-01 00:00:00", dateTimeFormatter);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            // yyyy-MM-dd
            return LocalDateTime.parse(source + " 00:00:00", dateTimeFormatter);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            // yyyy-MM-dd HH:mm
            return LocalDateTime.parse(source + ":00", dateTimeFormatter);
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            // yyyy-MM-dd HH:mm:ss
            return LocalDateTime.parse(source, dateTimeFormatter);
        } else {
            throw new IllegalArgumentException("Invalid datetime value '" + source + "'");
        }
    }
}