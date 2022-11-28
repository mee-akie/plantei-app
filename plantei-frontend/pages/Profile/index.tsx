import { useForm, SubmitHandler } from "react-hook-form";
import Image from "../../node_modules/next/image";

import Input from "../../components/Input/index";
import Button from "../../components/Button/index";
import Main from "../../components/Main";

import { LoginFooter, SpanInfo, LoginHeader, SubmitDiv, ImageProfile } from "../../styles/Profile";
import ToggleSwitch from "../../components/ToggleSwitch";

type Inputs = {
  nome: string,
  localizacao: string,
  espacoPlantio: string,
};

export default function Profile(props) {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors }
  } = useForm<Inputs>();
  
  const onSubmit: SubmitHandler<Inputs> = data => console.log(data);
  
  return (
    <Main backgroundColor="#FFFFFF" padding="1">
      <LoginHeader>
        <ImageProfile>
          <svg width={50} height={50} fill="none" stroke="#9AC979" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" /></svg>
        </ImageProfile>
      </LoginHeader>
      
      <form onSubmit={handleSubmit(onSubmit)}>
        <SpanInfo>Nome</SpanInfo>
        <Input
          {...register("nome", { required: true })}
          placeholder="Nome completo"
          border="1px solid #9AC979"
          backgroundColor="#9AC979"
          color="#FFFFFF"
          width={100}
          margin="10px 0 20px 0"
        />

        <SpanInfo>Localização</SpanInfo>
        <Input
          {...register("localizacao", { required: true })}
          placeholder="Sua cidade"
          border="1px solid #9AC979"
          backgroundColor="#9AC979"
          color="#FFFFFF"
          width={100}
          margin="10px 0 20px 0"
        />

        <SpanInfo>Espaço de plantio</SpanInfo>
        <Input
          {...register("espacoPlantio", { required: true })}
          placeholder="Espaço do plantio selecionado"
          border="1px solid #9AC979"
          backgroundColor="#9AC979"
          color="#FFFFFF"
          width={100}
          margin="10px 0 20px 0"
        />

        <ToggleSwitch>Desejo receber notificações para cuidados com a horta.</ToggleSwitch>
      </form>

      <LoginFooter>
        Menu
      </LoginFooter>
    </Main>
    );
  }
  