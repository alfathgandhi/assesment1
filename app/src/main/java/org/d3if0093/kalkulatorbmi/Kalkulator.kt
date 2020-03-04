package org.d3if0093.kalkulatorbmi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_kalkulator.*
import org.d3if0093.kalkulatorbmi.databinding.FragmentKalkulatorBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Kalkulator : Fragment() {
    private lateinit var binding: FragmentKalkulatorBinding
    private var ibm: Double = 0.0
    private lateinit var ideall:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kalkulator, container, false)
        if(savedInstanceState!=null){
            ideall=savedInstanceState.getString("ideal").toString()
            ibm=savedInstanceState.getDouble("ibm")
            binding.hasil.text = "Nilai BMI: $ibm"
            binding.ideal.text="$ideall"


        }

        binding.apply {
            hitung.setOnClickListener {
                var berat = beratInput.text.toString().toDouble()
                var tinggi = tinggiInput.text.toString().toDouble()
                tinggi = tinggi / 10
                ibm = berat / Math.pow(tinggi, 2.0)*100
                hasil.text = "Nilai BMI: $ibm"
                if (pria.isChecked && ibm < 20.50) {
                    ideal.text = "KURUS"
                } else if (pria.isChecked && 20.50 < ibm || ibm < 26.99) {
                    ideal.text = "IDEAL"

                } else if (pria.isChecked && ibm >= 27.00) {
                    ideal.text = "GEMUK"

                }else if(wanita.isChecked && ibm < 18.50){
                    ideal.text="KURUS"
                }else if(wanita.isChecked && 18.50<ibm||ibm<24.99){
                    ideal.text="IDEAL"
                }else if(wanita.isChecked&&ibm>=25.00){
                    ideal.text="GEMUK"
                }
            }
            saran.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_kalkulator_to_mengatasikurus)
            }


        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("ideal",binding.ideal.text.toString())
        outState.putDouble("ibm",ibm)
    }

}



