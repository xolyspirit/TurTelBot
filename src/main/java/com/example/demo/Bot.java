package com.example.demo;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {
    private final CityRepository cityRepository;

    public Bot(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            City city = cityRepository.findByName(update.getMessage().getText());
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId());
            if (city != null) {
                message.setText(city.getMessage());
            } else {
                message.setText("К сожалению, я ничего не знаю об этом месте.");
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "TourGuideBot";
    }

    @Override
    public String getBotToken() {
        return "907038349:AAHulQGZ6X1OGAXvO6OfmVkskAgyNpkizsU";
    }
}
