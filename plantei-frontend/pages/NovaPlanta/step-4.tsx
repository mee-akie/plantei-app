import { useForm, SubmitHandler } from "react-hook-form";
import Link from "next/link";
import Image from "next/image";

import Main from "../../components/Main";

import { CardSelect, Content, ContentForm, ContentFormSM, DivCards, NovaPlantaHeader, NovaPlantaText, ContentToPlant, SubmitDiv, SubmitDivTwoButtons } from "../../styles/NovaPlanta";
import Input from "../../components/Input";
import Button from "../../components/Button";
import { useRouter } from "next/router";
import BottomMenu from "../../components/BottomMenu";

type Inputs = {
  nome: string,
  sobrenome: string,
  email: string,
  senha: string,
};

export default function Step4(props) {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors }
  } = useForm<Inputs>();
  
  const onSubmit: SubmitHandler<Inputs> = data => console.log(data);
  const router = useRouter();
  console.log(watch("email"), errors)
  
  return (
    <Main backgroundColor="#FFFFFF" padding="2">
        <NovaPlantaHeader>
          <h2>Sua nova <span>planta</span></h2>
        </NovaPlantaHeader>
          <ContentFormSM onSubmit={handleSubmit(onSubmit)}>
            <Content className="contentsm">
            <ContentToPlant>
                <h3>Ajeitar terra, vaso ou garrafa PET</h3>
            </ContentToPlant>
            <ContentToPlant>
                <h3>Plantar o vegetal escolhido</h3>
            </ContentToPlant>
            <ContentToPlant>
                <h3>Cuidados gerais com a planta escolhida</h3>
            </ContentToPlant>
            
            <SubmitDivTwoButtons>
            <Button
                backgroundColor="#F3F3F3"
                width="min-content"
                color="#217B51"
                padding="20px 40px"
                fontSize="18px"
                onClick={() => router.push('/NovaPlanta/step-3')}
              >
                Voltar
              </Button>
              <Button
                backgroundColor="#217B51"
                width="min-content"
                color="#FFF"
                padding="20px 40px"
                fontSize="18px"
                onClick={() => router.push('/NovaPlanta/step-5')}
              >
                Continuar
              </Button>
            </SubmitDivTwoButtons>
            <BottomMenu backgroundColor="#FFF"></BottomMenu>
            </Content>
          </ContentFormSM>
    </Main>
  );
}
  