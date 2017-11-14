/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 026 */   private UnsafeRow agg_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     inputadapter_input = inputs[0];
/* 040 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 041 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     agg_result = new UnsafeRow(4);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 049 */     // initialize aggregation buffer
/* 050 */     boolean agg_isNull = false;
/* 051 */     double agg_value = -1.0;
/* 052 */     if (!false) {
/* 053 */       agg_value = (double) 0;
/* 054 */     }
/* 055 */     agg_bufIsNull = agg_isNull;
/* 056 */     agg_bufValue = agg_value;
/* 057 */     agg_bufIsNull1 = false;
/* 058 */     agg_bufValue1 = 0L;
/* 059 */     boolean agg_isNull3 = false;
/* 060 */     double agg_value3 = -1.0;
/* 061 */     if (!false) {
/* 062 */       agg_value3 = (double) 0;
/* 063 */     }
/* 064 */     agg_bufIsNull2 = agg_isNull3;
/* 065 */     agg_bufValue2 = agg_value3;
/* 066 */     agg_bufIsNull3 = false;
/* 067 */     agg_bufValue3 = 0L;
/* 068 */     boolean agg_isNull6 = false;
/* 069 */     double agg_value6 = -1.0;
/* 070 */     if (!false) {
/* 071 */       agg_value6 = (double) 0;
/* 072 */     }
/* 073 */     agg_bufIsNull4 = agg_isNull6;
/* 074 */     agg_bufValue4 = agg_value6;
/* 075 */     agg_bufIsNull5 = false;
/* 076 */     agg_bufValue5 = 0L;
/* 077 */     final double agg_value9 = -1.0;
/* 078 */     agg_bufIsNull6 = true;
/* 079 */     agg_bufValue6 = agg_value9;
/* 080 */
/* 081 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 082 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 083 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 084 */       double inputadapter_value = inputadapter_isNull ? -1.0 : (inputadapter_row.getDouble(0));
/* 085 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 086 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 087 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 088 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 089 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 090 */       long inputadapter_value3 = inputadapter_isNull3 ? -1L : (inputadapter_row.getLong(3));
/* 091 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 092 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 093 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 094 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 095 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 096 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 097 */
/* 098 */       // do aggregate
/* 099 */       // common sub-expressions
/* 100 */
/* 101 */       // evaluate aggregate function
/* 102 */       boolean agg_isNull27 = true;
/* 103 */       double agg_value27 = -1.0;
/* 104 */
/* 105 */       if (!agg_bufIsNull) {
/* 106 */         if (!inputadapter_isNull) {
/* 107 */           agg_isNull27 = false; // resultCode could change nullability.
/* 108 */           agg_value27 = agg_bufValue + inputadapter_value;
/* 109 */
/* 110 */         }
/* 111 */
/* 112 */       }
/* 113 */       boolean agg_isNull30 = true;
/* 114 */       long agg_value30 = -1L;
/* 115 */
/* 116 */       if (!agg_bufIsNull1) {
/* 117 */         if (!inputadapter_isNull1) {
/* 118 */           agg_isNull30 = false; // resultCode could change nullability.
/* 119 */           agg_value30 = agg_bufValue1 + inputadapter_value1;
/* 120 */
/* 121 */         }
/* 122 */
/* 123 */       }
/* 124 */       boolean agg_isNull33 = true;
/* 125 */       double agg_value33 = -1.0;
/* 126 */
/* 127 */       if (!agg_bufIsNull2) {
/* 128 */         if (!inputadapter_isNull2) {
/* 129 */           agg_isNull33 = false; // resultCode could change nullability.
/* 130 */           agg_value33 = agg_bufValue2 + inputadapter_value2;
/* 131 */
/* 132 */         }
/* 133 */
/* 134 */       }
/* 135 */       boolean agg_isNull36 = true;
/* 136 */       long agg_value36 = -1L;
/* 137 */
/* 138 */       if (!agg_bufIsNull3) {
/* 139 */         if (!inputadapter_isNull3) {
/* 140 */           agg_isNull36 = false; // resultCode could change nullability.
/* 141 */           agg_value36 = agg_bufValue3 + inputadapter_value3;
/* 142 */
/* 143 */         }
/* 144 */
/* 145 */       }
/* 146 */       boolean agg_isNull39 = true;
/* 147 */       double agg_value39 = -1.0;
/* 148 */
/* 149 */       if (!agg_bufIsNull4) {
/* 150 */         if (!inputadapter_isNull4) {
/* 151 */           agg_isNull39 = false; // resultCode could change nullability.
/* 152 */           agg_value39 = agg_bufValue4 + inputadapter_value4;
/* 153 */
/* 154 */         }
/* 155 */
/* 156 */       }
/* 157 */       boolean agg_isNull42 = true;
/* 158 */       long agg_value42 = -1L;
/* 159 */
/* 160 */       if (!agg_bufIsNull5) {
/* 161 */         if (!inputadapter_isNull5) {
/* 162 */           agg_isNull42 = false; // resultCode could change nullability.
/* 163 */           agg_value42 = agg_bufValue5 + inputadapter_value5;
/* 164 */
/* 165 */         }
/* 166 */
/* 167 */       }
/* 168 */       boolean agg_isNull46 = true;
/* 169 */       double agg_value46 = -1.0;
/* 170 */
/* 171 */       boolean agg_isNull47 = agg_bufIsNull6;
/* 172 */       double agg_value47 = agg_bufValue6;
/* 173 */       if (agg_isNull47) {
/* 174 */         boolean agg_isNull49 = false;
/* 175 */         double agg_value49 = -1.0;
/* 176 */         if (!false) {
/* 177 */           agg_value49 = (double) 0;
/* 178 */         }
/* 179 */         if (!agg_isNull49) {
/* 180 */           agg_isNull47 = false;
/* 181 */           agg_value47 = agg_value49;
/* 182 */         }
/* 183 */       }
/* 184 */
/* 185 */       if (!inputadapter_isNull6) {
/* 186 */         agg_isNull46 = false; // resultCode could change nullability.
/* 187 */         agg_value46 = agg_value47 + inputadapter_value6;
/* 188 */
/* 189 */       }
/* 190 */       boolean agg_isNull45 = agg_isNull46;
/* 191 */       double agg_value45 = agg_value46;
/* 192 */       if (agg_isNull45) {
/* 193 */         if (!agg_bufIsNull6) {
/* 194 */           agg_isNull45 = false;
/* 195 */           agg_value45 = agg_bufValue6;
/* 196 */         }
/* 197 */       }
/* 198 */       // update aggregation buffer
/* 199 */       agg_bufIsNull = agg_isNull27;
/* 200 */       agg_bufValue = agg_value27;
/* 201 */
/* 202 */       agg_bufIsNull1 = agg_isNull30;
/* 203 */       agg_bufValue1 = agg_value30;
/* 204 */
/* 205 */       agg_bufIsNull2 = agg_isNull33;
/* 206 */       agg_bufValue2 = agg_value33;
/* 207 */
/* 208 */       agg_bufIsNull3 = agg_isNull36;
/* 209 */       agg_bufValue3 = agg_value36;
/* 210 */
/* 211 */       agg_bufIsNull4 = agg_isNull39;
/* 212 */       agg_bufValue4 = agg_value39;
/* 213 */
/* 214 */       agg_bufIsNull5 = agg_isNull42;
/* 215 */       agg_bufValue5 = agg_value42;
/* 216 */
/* 217 */       agg_bufIsNull6 = agg_isNull45;
/* 218 */       agg_bufValue6 = agg_value45;
/* 219 */       if (shouldStop()) return;
/* 220 */     }
/* 221 */
/* 222 */   }
/* 223 */
/* 224 */   protected void processNext() throws java.io.IOException {
/* 225 */     while (!agg_initAgg) {
/* 226 */       agg_initAgg = true;
/* 227 */       long agg_beforeAgg = System.nanoTime();
/* 228 */       agg_doAggregateWithoutKey();
/* 229 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 230 */
/* 231 */       // output the result
/* 232 */       boolean agg_isNull12 = agg_bufIsNull1;
/* 233 */       double agg_value12 = -1.0;
/* 234 */       if (!agg_bufIsNull1) {
/* 235 */         agg_value12 = (double) agg_bufValue1;
/* 236 */       }
/* 237 */       boolean agg_isNull10 = false;
/* 238 */       double agg_value10 = -1.0;
/* 239 */       if (agg_isNull12 || agg_value12 == 0) {
/* 240 */         agg_isNull10 = true;
/* 241 */       } else {
/* 242 */         if (agg_bufIsNull) {
/* 243 */           agg_isNull10 = true;
/* 244 */         } else {
/* 245 */           agg_value10 = (double)(agg_bufValue / agg_value12);
/* 246 */         }
/* 247 */       }
/* 248 */       boolean agg_isNull16 = agg_bufIsNull3;
/* 249 */       double agg_value16 = -1.0;
/* 250 */       if (!agg_bufIsNull3) {
/* 251 */         agg_value16 = (double) agg_bufValue3;
/* 252 */       }
/* 253 */       boolean agg_isNull14 = false;
/* 254 */       double agg_value14 = -1.0;
/* 255 */       if (agg_isNull16 || agg_value16 == 0) {
/* 256 */         agg_isNull14 = true;
/* 257 */       } else {
/* 258 */         if (agg_bufIsNull2) {
/* 259 */           agg_isNull14 = true;
/* 260 */         } else {
/* 261 */           agg_value14 = (double)(agg_bufValue2 / agg_value16);
/* 262 */         }
/* 263 */       }
/* 264 */       boolean agg_isNull20 = agg_bufIsNull5;
/* 265 */       double agg_value20 = -1.0;
/* 266 */       if (!agg_bufIsNull5) {
/* 267 */         agg_value20 = (double) agg_bufValue5;
/* 268 */       }
/* 269 */       boolean agg_isNull18 = false;
/* 270 */       double agg_value18 = -1.0;
/* 271 */       if (agg_isNull20 || agg_value20 == 0) {
/* 272 */         agg_isNull18 = true;
/* 273 */       } else {
/* 274 */         if (agg_bufIsNull4) {
/* 275 */           agg_isNull18 = true;
/* 276 */         } else {
/* 277 */           agg_value18 = (double)(agg_bufValue4 / agg_value20);
/* 278 */         }
/* 279 */       }
/* 280 */
/* 281 */       agg_numOutputRows.add(1);
/* 282 */       agg_rowWriter.zeroOutNullBytes();
/* 283 */
/* 284 */       if (agg_isNull10) {
/* 285 */         agg_rowWriter.setNullAt(0);
/* 286 */       } else {
/* 287 */         agg_rowWriter.write(0, agg_value10);
/* 288 */       }
/* 289 */
/* 290 */       if (agg_isNull14) {
/* 291 */         agg_rowWriter.setNullAt(1);
/* 292 */       } else {
/* 293 */         agg_rowWriter.write(1, agg_value14);
/* 294 */       }
/* 295 */
/* 296 */       if (agg_isNull18) {
/* 297 */         agg_rowWriter.setNullAt(2);
/* 298 */       } else {
/* 299 */         agg_rowWriter.write(2, agg_value18);
/* 300 */       }
/* 301 */
/* 302 */       if (agg_bufIsNull6) {
/* 303 */         agg_rowWriter.setNullAt(3);
/* 304 */       } else {
/* 305 */         agg_rowWriter.write(3, agg_bufValue6);
/* 306 */       }
/* 307 */       append(agg_result);
/* 308 */     }
/* 309 */   }
/* 310 */ }
