import Fastify from "fastify";
import "dotenv/config";

const app = Fastify({
    logger: true,
});

app.get("/", async () => {
    return {
        message: "API Healthy"
    }
});

const start = async () => {
    try {
        const port = Number(process.env.PORT) || 3000;
        const host = process.env.HOST || "0.0.0.0";

        await app.listen({
            port,
            host,
        });
    } catch (error) {
        app.log.error(error);
        process.exit(1);
    }
};

start();