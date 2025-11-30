# AppMusic – Aula de Services (Programação para Dispositivos Móveis)

Universidade Federal de Rondônia – UNIR

Professor: Dr. Lucas Marques

# Objetivo do Aplicativo

O aplicativo tem como principal objetivo fornecer uma experiência simples, rápida e intuitiva para reprodução de músicas. Ele permite ao usuário buscar, selecionar e ouvir faixas enquanto oferece uma interface limpa e organizada. A aplicação foi projetada para manter a reprodução mesmo quando o usuário navega entre diferentes telas ou utiliza outros aplicativos, garantindo uma experiência contínua e agradável.

# Services no Android

No Android, **Services** são componentes que permitem executar tarefas em segundo plano sem a necessidade de interação direta com a interface do usuário. Eles são essenciais para funcionalidades que precisam continuar funcionando mesmo quando a aplicação não está visível.

## Tipos de Services utilizados em apps de música

### 1. **Foreground Service**
Um *Foreground Service* é um serviço que permanece ativo e visível ao usuário através de uma notificação fixa. No contexto do aplicativo de música, ele é responsável por manter a reprodução ativa mesmo quando o app está em segundo plano, além de permitir controles rápidos como pausar, avançar ou retroceder faixas.

### 2. **Background Execution**
O serviço garante que a música não seja interrompida ao trocar de tela ou bloquear o aparelho. Ele administra o player, controla eventos de mídia e gerencia os recursos do sistema para que a reprodução seja eficiente.

## Objetivo do uso de Services no app

- Manter a música tocando enquanto o usuário usa outros apps;
- Garantir que o player continue mesmo que a Activity seja destruída;
- Controlar notificações e ações de mídia;
- Evitar interrupções e melhorar a experiência geral do usuário.

Os Services são, portanto, uma parte fundamental no fluxo do aplicativo, garantindo desempenho, continuidade e maior controle sobre a reprodução em segundo plano.
<img width="1393" height="689" alt="image" src="https://github.com/user-attachments/assets/afa2b565-f537-45b5-97e7-ba05a3f0869f" />

