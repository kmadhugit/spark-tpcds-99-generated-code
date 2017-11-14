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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value10;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(2);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(4);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 4);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 073 */
/* 074 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 075 */
/* 076 */       UnsafeRow agg_fastAggBuffer = null;
/* 077 */
/* 078 */       if (agg_fastAggBuffer == null) {
/* 079 */         // generate grouping key
/* 080 */         agg_rowWriter.zeroOutNullBytes();
/* 081 */
/* 082 */         if (inputadapter_isNull) {
/* 083 */           agg_rowWriter.setNullAt(0);
/* 084 */         } else {
/* 085 */           agg_rowWriter.write(0, inputadapter_value);
/* 086 */         }
/* 087 */
/* 088 */         if (inputadapter_isNull1) {
/* 089 */           agg_rowWriter.setNullAt(1);
/* 090 */         } else {
/* 091 */           agg_rowWriter.write(1, inputadapter_value1);
/* 092 */         }
/* 093 */         agg_value10 = 42;
/* 094 */
/* 095 */         if (!inputadapter_isNull) {
/* 096 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value10);
/* 097 */         }
/* 098 */
/* 099 */         if (!inputadapter_isNull1) {
/* 100 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value10);
/* 101 */         }
/* 102 */         if (true) {
/* 103 */           // try to get the buffer from hash map
/* 104 */           agg_unsafeRowAggBuffer =
/* 105 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 106 */         }
/* 107 */         if (agg_unsafeRowAggBuffer == null) {
/* 108 */           if (agg_sorter == null) {
/* 109 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 110 */           } else {
/* 111 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 112 */           }
/* 113 */
/* 114 */           // the hash map had be spilled, it should have enough memory now,
/* 115 */           // try  to allocate buffer again.
/* 116 */           agg_unsafeRowAggBuffer =
/* 117 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 118 */           if (agg_unsafeRowAggBuffer == null) {
/* 119 */             // failed to allocate the first page
/* 120 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 121 */           }
/* 122 */         }
/* 123 */       }
/* 124 */
/* 125 */       if (agg_fastAggBuffer != null) {
/* 126 */         // update fast row
/* 127 */
/* 128 */       } else {
/* 129 */         // update unsafe row
/* 130 */
/* 131 */         // common sub-expressions
/* 132 */         boolean agg_isNull10 = false;
/* 133 */         double agg_value13 = -1.0;
/* 134 */         if (!false) {
/* 135 */           agg_value13 = (double) 0;
/* 136 */         }
/* 137 */         // evaluate aggregate function
/* 138 */         boolean agg_isNull13 = true;
/* 139 */         double agg_value16 = -1.0;
/* 140 */
/* 141 */         boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 142 */         double agg_value18 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 143 */         boolean agg_isNull14 = agg_isNull15;
/* 144 */         double agg_value17 = agg_value18;
/* 145 */         if (agg_isNull14) {
/* 146 */           if (!agg_isNull10) {
/* 147 */             agg_isNull14 = false;
/* 148 */             agg_value17 = agg_value13;
/* 149 */           }
/* 150 */         }
/* 151 */
/* 152 */         if (!inputadapter_isNull2) {
/* 153 */           agg_isNull13 = false; // resultCode could change nullability.
/* 154 */           agg_value16 = agg_value17 + inputadapter_value2;
/* 155 */
/* 156 */         }
/* 157 */         boolean agg_isNull12 = agg_isNull13;
/* 158 */         double agg_value15 = agg_value16;
/* 159 */         if (agg_isNull12) {
/* 160 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 161 */           double agg_value20 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 162 */           if (!agg_isNull17) {
/* 163 */             agg_isNull12 = false;
/* 164 */             agg_value15 = agg_value20;
/* 165 */           }
/* 166 */         }
/* 167 */         boolean agg_isNull19 = true;
/* 168 */         double agg_value22 = -1.0;
/* 169 */
/* 170 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 171 */         double agg_value24 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 172 */         boolean agg_isNull20 = agg_isNull21;
/* 173 */         double agg_value23 = agg_value24;
/* 174 */         if (agg_isNull20) {
/* 175 */           if (!agg_isNull10) {
/* 176 */             agg_isNull20 = false;
/* 177 */             agg_value23 = agg_value13;
/* 178 */           }
/* 179 */         }
/* 180 */
/* 181 */         if (!inputadapter_isNull3) {
/* 182 */           agg_isNull19 = false; // resultCode could change nullability.
/* 183 */           agg_value22 = agg_value23 + inputadapter_value3;
/* 184 */
/* 185 */         }
/* 186 */         boolean agg_isNull18 = agg_isNull19;
/* 187 */         double agg_value21 = agg_value22;
/* 188 */         if (agg_isNull18) {
/* 189 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 190 */           double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 191 */           if (!agg_isNull23) {
/* 192 */             agg_isNull18 = false;
/* 193 */             agg_value21 = agg_value26;
/* 194 */           }
/* 195 */         }
/* 196 */         boolean agg_isNull25 = true;
/* 197 */         double agg_value28 = -1.0;
/* 198 */
/* 199 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 200 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 201 */         boolean agg_isNull26 = agg_isNull27;
/* 202 */         double agg_value29 = agg_value30;
/* 203 */         if (agg_isNull26) {
/* 204 */           if (!agg_isNull10) {
/* 205 */             agg_isNull26 = false;
/* 206 */             agg_value29 = agg_value13;
/* 207 */           }
/* 208 */         }
/* 209 */
/* 210 */         if (!inputadapter_isNull4) {
/* 211 */           agg_isNull25 = false; // resultCode could change nullability.
/* 212 */           agg_value28 = agg_value29 + inputadapter_value4;
/* 213 */
/* 214 */         }
/* 215 */         boolean agg_isNull24 = agg_isNull25;
/* 216 */         double agg_value27 = agg_value28;
/* 217 */         if (agg_isNull24) {
/* 218 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 219 */           double agg_value32 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 220 */           if (!agg_isNull29) {
/* 221 */             agg_isNull24 = false;
/* 222 */             agg_value27 = agg_value32;
/* 223 */           }
/* 224 */         }
/* 225 */         // update unsafe row buffer
/* 226 */         if (!agg_isNull12) {
/* 227 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 228 */         } else {
/* 229 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 230 */         }
/* 231 */
/* 232 */         if (!agg_isNull18) {
/* 233 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value21);
/* 234 */         } else {
/* 235 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 236 */         }
/* 237 */
/* 238 */         if (!agg_isNull24) {
/* 239 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 240 */         } else {
/* 241 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 242 */         }
/* 243 */
/* 244 */       }
/* 245 */       if (shouldStop()) return;
/* 246 */     }
/* 247 */
/* 248 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 249 */   }
/* 250 */
/* 251 */   protected void processNext() throws java.io.IOException {
/* 252 */     if (!agg_initAgg) {
/* 253 */       agg_initAgg = true;
/* 254 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 255 */       agg_doAggregateWithKeys();
/* 256 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 257 */     }
/* 258 */
/* 259 */     // output the result
/* 260 */
/* 261 */     while (agg_mapIter.next()) {
/* 262 */       wholestagecodegen_numOutputRows.add(1);
/* 263 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 264 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 265 */
/* 266 */       boolean agg_isNull30 = agg_aggKey.isNullAt(0);
/* 267 */       int agg_value33 = agg_isNull30 ? -1 : (agg_aggKey.getInt(0));
/* 268 */       boolean agg_isNull31 = agg_aggKey.isNullAt(1);
/* 269 */       int agg_value34 = agg_isNull31 ? -1 : (agg_aggKey.getInt(1));
/* 270 */       boolean agg_isNull32 = agg_aggBuffer.isNullAt(0);
/* 271 */       double agg_value35 = agg_isNull32 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 272 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(1);
/* 273 */       double agg_value36 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 274 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(2);
/* 275 */       double agg_value37 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 276 */
/* 277 */       agg_rowWriter1.zeroOutNullBytes();
/* 278 */
/* 279 */       if (agg_isNull30) {
/* 280 */         agg_rowWriter1.setNullAt(0);
/* 281 */       } else {
/* 282 */         agg_rowWriter1.write(0, agg_value33);
/* 283 */       }
/* 284 */
/* 285 */       if (agg_isNull32) {
/* 286 */         agg_rowWriter1.setNullAt(1);
/* 287 */       } else {
/* 288 */         agg_rowWriter1.write(1, agg_value35);
/* 289 */       }
/* 290 */
/* 291 */       if (agg_isNull33) {
/* 292 */         agg_rowWriter1.setNullAt(2);
/* 293 */       } else {
/* 294 */         agg_rowWriter1.write(2, agg_value36);
/* 295 */       }
/* 296 */
/* 297 */       if (agg_isNull34) {
/* 298 */         agg_rowWriter1.setNullAt(3);
/* 299 */       } else {
/* 300 */         agg_rowWriter1.write(3, agg_value37);
/* 301 */       }
/* 302 */       append(agg_result1);
/* 303 */
/* 304 */       if (shouldStop()) return;
/* 305 */     }
/* 306 */
/* 307 */     agg_mapIter.close();
/* 308 */     if (agg_sorter == null) {
/* 309 */       agg_hashMap.free();
/* 310 */     }
/* 311 */   }
/* 312 */ }
