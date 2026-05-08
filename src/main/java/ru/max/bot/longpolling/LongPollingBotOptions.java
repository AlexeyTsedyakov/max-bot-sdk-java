package ru.max.bot.longpolling;

import java.util.Set;

import org.jetbrains.annotations.Nullable;
import dev.mccue.guava.concurrent.RateLimiter;

import ru.max.bot.MaxBotOptions;

public class LongPollingBotOptions extends MaxBotOptions {
    public static final LongPollingBotOptions DEFAULT = new LongPollingBotOptions(30, null, null, true, 2.0);

    private final int requestTimeout;
    private final Integer limit;
    private final boolean shouldRemoveWebhook;
    private final RateLimiter rateLimiter;

    public LongPollingBotOptions(int requestTimeout, @Nullable Integer limit, @Nullable Set<String> updateTypes,
                                 boolean shouldRemoveWebhook, double reqPerSec) {
        super(updateTypes);
        this.requestTimeout = requestTimeout;
        this.limit = limit;
        this.shouldRemoveWebhook = shouldRemoveWebhook;
        this.rateLimiter = RateLimiter.create(reqPerSec);
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    @Nullable
    public Integer getLimit() {
        return limit;
    }

    public boolean shouldRemoveWebhook() {
        return shouldRemoveWebhook;
    }

    public RateLimiter getRateLimiter() { return rateLimiter; }
}
