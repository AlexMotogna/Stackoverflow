import {render} from '@testing-library/vue'
import Logo from '@/components/Logo.vue'

test('test', async () => {
  render(Logo)
  expect(true)
})
