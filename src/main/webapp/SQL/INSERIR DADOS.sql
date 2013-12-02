

-- sis_semana
-- Criate: 2013-07-24
-- Last edition: 2013-07-24 - by: Bruno Vieira

INSERT INTO sis_semana (id, ds_descricao) SELECT 1, 'Domingo'   WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 1 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 2, 'Segunda'   WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 2 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 3, 'Terça'     WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 3 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 4, 'Quarta'    WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 4 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 5, 'Quinta'    WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 5 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 6, 'Sexta'     WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 6 );
INSERT INTO sis_semana (id, ds_descricao) SELECT 7, 'Sábado'    WHERE NOT EXISTS ( SELECT id FROM sis_semana WHERE id = 7 );
SELECT setval('sis_semana_id_seq', max(id)) FROM sis_semana;

-- seg_modulo
-- Criate: 2013-07-24
-- Last edition: 2013-07-24 - by: Bruno Vieira

-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 1, 'Financeiro'        WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 1);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 2, 'Social'            WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 2);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 3, 'Arrecadação'       WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 3);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 4, 'Homologação'       WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 4);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 5, 'Jurídico'          WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 5);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 6, 'Clube'             WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 6);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 7, 'Academia'          WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 7);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 8, 'Escola'            WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 8);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 9, 'Cadastro Auxiliar' WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 9);
-- INSERT INTO seg_modulo (id, ds_descricao) SELECT 10, 'Segurança'        WHERE NOT EXISTS ( SELECT id FROM seg_modulo WHERE id = 10);
-- SELECT setval('seg_modulo_id_seq', max(id)) FROM seg_modulo;

-- seg_evento
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

INSERT INTO seg_evento (id, ds_descricao) SELECT 1, 'Inclusão'  WHERE NOT EXISTS ( SELECT id FROM seg_evento WHERE id = 1);
INSERT INTO seg_evento (id, ds_descricao) SELECT 2, 'Exclusão'  WHERE NOT EXISTS ( SELECT id FROM seg_evento WHERE id = 2);
INSERT INTO seg_evento (id, ds_descricao) SELECT 3, 'Alteração' WHERE NOT EXISTS ( SELECT id FROM seg_evento WHERE id = 3);
INSERT INTO seg_evento (id, ds_descricao) SELECT 4, 'Consulta'  WHERE NOT EXISTS ( SELECT id FROM seg_evento WHERE id = 4);
SELECT setval('seg_evento_id_seq', max(id)) FROM seg_evento;

-- seg_nivel 
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira


INSERT INTO seg_nivel (id, ds_descricao) SELECT 1, 'Usuario'   WHERE NOT EXISTS ( SELECT id FROM seg_nivel WHERE id = 1);
INSERT INTO seg_nivel (id, ds_descricao) SELECT 2, 'Usuário (Avançado)'    WHERE NOT EXISTS ( SELECT id FROM seg_nivel WHERE id = 2);
INSERT INTO seg_nivel (id, ds_descricao) SELECT 3, 'Coordenador (Depto)' WHERE NOT EXISTS ( SELECT id FROM seg_nivel WHERE id = 3);
INSERT INTO seg_nivel (id, ds_descricao) SELECT 4, 'Gerente'  WHERE NOT EXISTS ( SELECT id FROM seg_nivel WHERE id = 4);
INSERT INTO seg_nivel (id, ds_descricao) SELECT 5, 'Administrador' WHERE NOT EXISTS ( SELECT id FROM seg_nivel WHERE id = 5);
SELECT setval('seg_nivel_id_seq', max(id)) FROM seg_nivel;


-- seg_rotina
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

-- INSERT INTO seg_rotina (id, ds_rotina, ds_nome_pagina, ds_classe, is_ativo) SELECT 1, 'Rotina', 'rotina.jsf', '', true WHERE NOT EXISTS ( SELECT id FROM seg_rotina WHERE id = 1);
-- INSERT INTO seg_rotina (id, ds_rotina, ds_nome_pagina, ds_classe, is_ativo) SELECT 2, 'Usuários Administrativos', 'usuarioAdministrador.jsf', '', true WHERE NOT EXISTS ( SELECT id FROM seg_rotina WHERE id = 2);
-- SELECT setval('seg_rotina_id_seq', max(id)) FROM seg_rotina;

-- arr_repis_status
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 1, 'Residencial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 1);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 2, 'Comercial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 2);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 3, 'Cobrança' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 3);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 4, 'Correspondência' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 4);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 5, 'Base Territorial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 5);
SELECT setval('pes_tipo_endereco_id_seq', max(id)) FROM pes_tipo_endereco;

-- pes_tipo_usuario_acesso
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

INSERT INTO seg_tipo_usuario_acesso (id, ds_descricao) SELECT 1, 'Administrador' WHERE NOT EXISTS ( SELECT id FROM seg_tipo_usuario_acesso WHERE id = 1);
INSERT INTO seg_tipo_usuario_acesso (id, ds_descricao) SELECT 2, 'Empresa' WHERE NOT EXISTS ( SELECT id FROM seg_tipo_usuario_acesso WHERE id = 2);
INSERT INTO seg_tipo_usuario_acesso (id, ds_descricao) SELECT 3, 'Cliente' WHERE NOT EXISTS ( SELECT id FROM seg_tipo_usuario_acesso WHERE id = 3);
SELECT setval('seg_tipo_usuario_acesso_id_seq', max(id)) FROM seg_tipo_usuario_acesso;

-- end_logradouro 
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 0, "' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 0); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 1, 'CAMPO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 1); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 2, 'RUA PROJETADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 2); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 3, 'RUA VELHA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 3); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 4, 'TREVO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 4); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 5, '16ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 5); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 6, '3ª VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 6); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 7, 'AVENIDA VELHA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 7); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 8, 'PASSAGEM' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 8); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 9, 'PASSEIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 9); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 10, 'PROLONGAMENTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 10); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 11, 'RODO ANEL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 11); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 12, 'RUELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 12); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 13, 'CAMPUS' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 13); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 14, 'SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 14); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 15, 'FERROVIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 15); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 16, '2ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 16); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 17, 'COLÔNIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 17); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 18, 'BURACO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 18); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 19, 'ESCADARIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 19); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 20, 'PASSEIO PÚBLICO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 20); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 21, 'ENTRE QUADRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 21); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 22, 'ÁREA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 22); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 23, 'ESTRADA DE LIGAÇÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 23); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 24, 'VIA PRINCIPAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 24); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 25, 'COMPLEXO VIÁRIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 25); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 26, 'CONJUNTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 26); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 27, 'PARQUE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 27); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 28, 'VALE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 28); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 29, '12ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 29); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 30, 'ADRO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 30); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 31, 'CALÇADÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 31); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 32, '4ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 32); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 33, '2ª PARALELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 33); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 34, 'BELVEDERE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 34); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 35, '6ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 35); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 36, '1ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 36); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 37, 'JARDINETE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 37); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 38, '2º ALTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 38); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 39, 'MARINA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 39); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 40, 'GALERIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 40); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 41, 'VIA COSTEIRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 41); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 42, 'ESTRADA PARTICULAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 42); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 43, 'PRAIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 43); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 44, '5ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 44); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 45, 'NÚCLEO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 45); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 46, 'VIA LATERAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 46); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 47, 'BAIXA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 47); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 48, 'TRECHO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 48); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 49, '4ª VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 49); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 50, '3º ALTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 50); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 51, '4ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 51); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 52, '3º BECO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 52); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 53, '1ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 53); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 54, 'RUA PRINCIPAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 54); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 55, 'RUA DE LIGAÇÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 55); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 56, 'RAMAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 56); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 57, 'PARALELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 57); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 58, 'ENTRADA PARTICULAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 58); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 59, 'COMUNIDADE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 59); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 60, 'CHÁCARA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 60); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 61, 'BALÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 61); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 62, 'PASSAGEM SUBTERRÂNEA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 62); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 63, '7ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 63); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 64, 'VIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 64); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 65, 'ESTRADA INTERMUNICIPAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 65); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 66, 'VIA DE ACESSO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 66); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 67, 'VIA COLETORA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 67); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 68, 'RUA DE PEDESTRE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 68); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 69, 'CORREDOR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 69); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 70, 'VIADUTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 70); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 71, '9ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 71); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 72, '13ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 72); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 73, 'AVENIDA MARGINAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 73); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 74, 'AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 74); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 75, 'ELEVADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 75); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 76, 'JARDIM' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 76); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 77, 'TERMINAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 77); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 78, '2ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 78); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 79, 'GRANJA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 79); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 80, '1ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 80); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 81, 'CAMINHO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 81); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 82, 'RECANTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 82); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 83, 'QUINTA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 83); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 84, 'ESCADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 84); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 85, 'RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 85); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 86, 'CICLOVIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 86); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 87, 'RAMPA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 87); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 88, '5ª VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 88); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 89, 'QUADRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 89); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 90, 'TRAVESSA PARTICULAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 90); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 91, '5ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 91); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 92, 'EIXO INDUSTRIAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 92); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 93, 'FAVELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 93); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 94, 'RETORNO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 94); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 95, 'ESTRADA ESTADUAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 95); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 96, 'ACESSO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 96); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 97, 'PRAÇA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 97); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 98, 'CANAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 98); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 99, 'AEROPORTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 99); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 100, 'ALAMEDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 100); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 101, '4ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 101); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 102, 'BULEVAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 102); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 103, 'RETA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 103); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 104, 'DISTRITO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 104); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 105, 'ESTRADA MUNICIPAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 105); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 106, 'ESPLANADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 106); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 107, '15ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 107); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 108, '4ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 108); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 109, '2ª TRAVESSA DA RODOVIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 109); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 110, 'ESTRADA ANTIGA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 110); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 111, 'FONTE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 111); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 112, 'ILHA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 112); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 113, 'VIELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 113); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 114, 'PARADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 114); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 115, 'PARQUE MUNICIPAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 115); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 116, 'PARQUE RESIDENCIAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 116); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 117, 'BLOCO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 117); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 118, 'AVENIDA MARGINAL ESQUERDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 118); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 119, 'BOSQUE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 119); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 120, 'LOTEAMENTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 120); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 121, 'CONJUNTO MUTIRÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 121); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 122, 'BECO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 122); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 123, 'TÚNEL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 123); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 124, '4ª PARALELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 124); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 125, 'VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 125); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 126, 'VIA DE PEDESTRE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 126); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 127, 'FORTE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 127); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 128, '10ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 128); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 129, 'RUA PARTICULAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 129); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 130, 'AVENIDA MARGINAL DIREITA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 130); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 131, '3ª PARALELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 131); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 132, 'VIA EXPRESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 132); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 133, '1ª TRAVESSA DA RODOVIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 133); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 134, '7ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 134); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 135, 'FAZENDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 135); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 136, '11ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 136); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 137, '1ª VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 137); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 138, 'CALÇADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 138); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 139, 'VIA LITORANEA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 139); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 140, 'LADEIRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 140); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 141, '8ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 141); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 142, 'CÓRREGO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 142); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 143, 'ESTACIONAMENTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 143); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 144, '9ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 144); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 145, '5ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 145); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 146, 'ESTÁDIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 146); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 147, '2ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 147); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 148, '3ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 148); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 149, '3ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 149); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 150, 'AVENIDA CONTORNO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 150); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 151, 'AVENIDA PERIMETRAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 151); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 152, 'ARTÉRIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 152); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 153, 'MORRO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 153); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 154, 'RESIDENCIAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 154); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 155, 'ESTRADA VELHA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 155); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 156, 'DESVIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 156); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 157, '2ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 157); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 158, 'VIA PEDESTRE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 158); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 159, 'PONTE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 159); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 160, 'VEREDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 160); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 161, 'VIA LOCAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 161); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 162, 'PRAÇA DE ESPORTES' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 162); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 163, 'PASSARELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 163); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 164, '2º BECO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 164); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 165, 'NÚCLEO RURAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 165); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 166, 'MARGEM' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 166); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 167, '10ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 167); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 168, 'CIRCULAR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 168); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 169, '11ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 169); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 170, 'TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 170); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 171, 'ROTATÓRIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 171); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 172, '6ª SUBIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 172); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 173, '1º ALTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 173); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 174, 'ESTRADA VICINAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 174); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 175, 'CONDOMÍNIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 175); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 176, '2ª VILA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 176); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 177, '12ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 177); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 178, '6ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 178); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 179, 'CAIS' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 179); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 180, 'CAMINHO DE SERVIDÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 180); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 181, '3ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 181); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 182, '14ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 182); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 183, 'ESTRADA DE SERVIDÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 183); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 184, 'SÍTIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 184); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 185, 'BLOCOS' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 185); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 186, 'LARGO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 186); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 187, '3ª LADEIRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 187); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 188, 'RODOVIA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 188); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 189, 'ZIGUE-ZAGUE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 189); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 190, 'FEIRA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 190); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 191, '6ª AVENIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 191); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 192, 'ACAMPAMENTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 192); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 193, 'SETOR' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 193); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 194, '1ª PARALELA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 194); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 195, 'CONTORNO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 195); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 196, 'RETIRO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 196); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 197, 'LAGO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 197); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 198, 'MÓDULO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 198); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 199, 'BOULEVARD' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 199); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 200, 'DESCIDA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 200); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 201, 'NÚCLEO HABITACIONAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 201); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 202, 'ESTAÇÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 202); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 203, 'ÁREA VERDE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 203); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 204, 'CONDOMÍNIO RESIDENCIAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 204); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 205, 'AVENIDA MARGINAL NORTE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 205); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 206, 'ÁREA ESPECIAL' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 206); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 207, '3ª TRAVESSA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 207); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 208, '1º BECO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 208); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 209, '1ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 209); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 210, 'UNIDADE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 210); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 211, 'LAGOA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 211); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 212, '5ª RUA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 212); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 213, 'ATALHO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 213); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 214, 'PASSAGEM DE PEDESTRES' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 214); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 215, 'ALTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 215); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 216, 'ESTRADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 216); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 217, 'MONTE' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 217); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 218, 'ESTRADA DE FERRO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 218); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 219, 'RÓTULA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 219); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 220, 'VIA DE PEDESTRES' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 220); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 221, 'PÁTIO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 221); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 222, 'PONTA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 222); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 223, 'ANTIGA ESTRADA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 223); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 224, 'PORTO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 224); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 225, 'VALA' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 225); 
-- INSERT INTO end_logradouro (id, ds_descricao) SELECT 226, 'SERVIDÃO' WHERE NOT EXISTS ( SELECT id FROM end_logradouro WHERE id = 226); 
SELECT setval('end_logradouro_id_seq', max(id)) FROM end_logradouro;

-- pes_tipo_documento 
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

INSERT INTO pes_tipo_documento (id, ds_descricao) SELECT 1, 'CPF' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_documento WHERE id = 1);
INSERT INTO pes_tipo_documento (id, ds_descricao) SELECT 2, 'CNPJ' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_documento WHERE id = 2);
INSERT INTO pes_tipo_documento (id, ds_descricao) SELECT 3, 'CEI' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_documento WHERE id = 3);
INSERT INTO pes_tipo_documento (id, ds_descricao) SELECT 4, 'SEM DOCUMENTO' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_documento WHERE id = 4);
SELECT setval('pes_tipo_documento_id_seq', max(id)) FROM pes_tipo_documento;

-- pes_tipo_endereco 
-- Criate: 2013-08-02
-- Last edition: 2013-08-02 - by: Bruno Vieira

INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 1, 'Residencial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 1);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 2, 'Comercial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 2);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 3, 'Cobrança' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 3);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 4, 'Correspondência' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 4);
INSERT INTO pes_tipo_endereco (id, ds_descricao) SELECT 5, 'Base Territorial' WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 5);
SELECT setval('pes_tipo_endereco_id_seq', max(id)) FROM pes_tipo_endereco;

-- pes_porte 
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira

INSERT INTO pes_porte (id, ds_descricao) SELECT 1, 'ME' WHERE NOT EXISTS ( SELECT id FROM pes_porte WHERE id = 1);
INSERT INTO pes_porte (id, ds_descricao) SELECT 2, 'EPP' WHERE NOT EXISTS ( SELECT id FROM pes_porte WHERE id = 2);
SELECT setval('pes_porte_id_seq', max(id)) FROM pes_porte;

-- pes_pessoa
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira



INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 1, 'Black Tie', 'black-tie', false  WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 1);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 2, 'Bluesky', 'bluesky', false  WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 2);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 3, 'Casablanca', 'casablanca', false WHERE NOT EXISTS ( SELECT id FROM pes_tipo_endereco WHERE id = 3);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 4, 'Cupertino', 'cupertino', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 4);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 5, 'Excite Bike', 'excite-bike', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 5);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 6, 'Flick', 'flick', true  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 6);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 7, 'Glass X', 'glass-x', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 7);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 8, 'Home', 'home', true  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 8);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 9, 'Hot Sneaks', 'hot-sneaks', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 9);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 10, 'Overcast', 'overcast', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 10);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 11, 'Smoothness', 'smoothness', true  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 11);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 12, 'South Street', 'south-street', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 12);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 13, 'Sunny', 'sunny', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 13);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 14, 'Swanky Purse', 'swanky-purse', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 14);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 15, 'Trontastic', 'trontastic', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 15);
INSERT INTO sis_temas (id, ds_descricao, ds_identificador, is_ativo) SELECT 16, 'Vader', 'vader', false  WHERE NOT EXISTS ( SELECT id FROM sis_temas WHERE id = 16);
SELECT setval('sis_temas_id_seq', max(id)) FROM sis_temas;


-- START

INSERT INTO pes_pessoa(id, ds_nome, id_tipo_documento) SELECT 1, 'Administrador', '1' WHERE NOT EXISTS ( SELECT id FROM pes_pessoa WHERE id = 1);
SELECT setval('pes_pessoa_id_seq', max(id)) FROM pes_pessoa;
INSERT INTO seg_usuario(id, id_pessoa, ds_login, ds_senha, is_ativo, dt_cadastro, id_tipo_usuario_acesso) SELECT 1, 1, 'admin', '989899', true, current_date, 1 WHERE NOT EXISTS ( SELECT id FROM seg_usuario WHERE id = 1);
SELECT setval('seg_usuario_id_seq', max(id)) FROM seg_usuario;
INSERT INTO seg_usuario_administrador(id, id_usuario) SELECT 1, 1 WHERE NOT EXISTS ( SELECT id FROM seg_usuario_administrador WHERE id = 1);
SELECT setval('seg_usuario_administrador_id_seq', max(id)) FROM seg_usuario_administrador;


-- end_regiao
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira
INSERT INTO end_regiao(id, ds_descricao ) VALUES (1, 'Centro-Oeste'), (2, 'Nordeste'),(3, 'Norte'),(4, 'Sudeste'),(5, 'Sul');

-- end_subregiao
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira
INSERT INTO end_subregiao (id, ds_descricao) VALUES (1, "");

-- end_estado
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira

INSERT INTO end_estado (id, id_regiao, ds_sigla, ds_descricao)
                        VALUES  (1, 3, 'AC', 'Acre'),
                                (2, 2, 'AL', 'Alagoas'),
                                (3, 3, 'AM', 'Amazonas'),
                                (4, 3, 'AP', 'Amapá'),
                                (5, 2, 'BA', 'Bahia'),
                                (6, 2, 'CE', 'Ceará'),
                                (7, 1, 'DF', 'Distrito Federal'),
                                (8, 4, 'ES', 'Espirito Santo'),
                                (9, 1, 'GO', 'Goiás'),
                                (10, 2, 'MA', 'Maranhão'),
                                (11, 4, 'MG', 'Mina Gerais'),
                                (12, 1, 'MT', 'Mato Grosso'),
                                (13, 1, 'MS', 'Mato Grosso do Sul'),
                                (14, 3, 'PA', 'Pará'),
                                (15, 2, 'PB', 'Paraíba'),
                                (16, 2, 'PE', 'Pernambuco'),
                                (17, 2, 'PI', 'Piauí'),
                                (18, 5, 'PR', 'Paraná'),
                                (19, 4, 'RJ', 'Rio de Janeiro'),
                                (20, 2, 'RN', 'Rio Grande do Norte'),
                                (21, 3, 'RO', 'Rondônia'),
                                (22, 3, 'RR', 'Roraíma'),
                                (23, 5, 'RS', 'Rio Grande do Sul'),
                                (24, 5, 'SC', 'Santa Catarina'),
                                (25, 2, 'SE', 'Sergipe'),
                                (26, 4, 'SP', 'São Paulo'),
                                (27, 3, 'TO', 'Tocantins');

-- pes_sexo
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira
INSERT INTO pes_sexo (id, ds_descricao) VALUES (1, ''), (2, 'MASCULINO'),(3, 'FEMININO');

-- pes_estado_civil 
-- Criate: 2013-08-07
-- Last edition: 2013-08-07 - by: Bruno Vieira
INSERT INTO pes_estado_civil (id, ds_descricao) VALUES (1, ''), (2, 'SOLTEIRO(a)'), (3, 'CASADO(a)'), (4, 'DESQUITADO(a)'), (5, 'VIÚVO(a)');