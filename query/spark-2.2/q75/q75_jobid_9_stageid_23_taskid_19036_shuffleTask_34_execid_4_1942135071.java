/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value14;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
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
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(5);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(7);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 069 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 070 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 071 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 072 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 073 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 074 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull1) {
/* 091 */           agg_rowWriter.setNullAt(1);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(1, inputadapter_value1);
/* 094 */         }
/* 095 */
/* 096 */         if (inputadapter_isNull2) {
/* 097 */           agg_rowWriter.setNullAt(2);
/* 098 */         } else {
/* 099 */           agg_rowWriter.write(2, inputadapter_value2);
/* 100 */         }
/* 101 */
/* 102 */         if (inputadapter_isNull3) {
/* 103 */           agg_rowWriter.setNullAt(3);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(3, inputadapter_value3);
/* 106 */         }
/* 107 */
/* 108 */         if (inputadapter_isNull4) {
/* 109 */           agg_rowWriter.setNullAt(4);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(4, inputadapter_value4);
/* 112 */         }
/* 113 */         agg_value14 = 42;
/* 114 */
/* 115 */         if (!inputadapter_isNull) {
/* 116 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value14);
/* 117 */         }
/* 118 */
/* 119 */         if (!inputadapter_isNull1) {
/* 120 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 121 */         }
/* 122 */
/* 123 */         if (!inputadapter_isNull2) {
/* 124 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 125 */         }
/* 126 */
/* 127 */         if (!inputadapter_isNull3) {
/* 128 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 129 */         }
/* 130 */
/* 131 */         if (!inputadapter_isNull4) {
/* 132 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value14);
/* 133 */         }
/* 134 */         if (true) {
/* 135 */           // try to get the buffer from hash map
/* 136 */           agg_unsafeRowAggBuffer =
/* 137 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 138 */         }
/* 139 */         if (agg_unsafeRowAggBuffer == null) {
/* 140 */           if (agg_sorter == null) {
/* 141 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 142 */           } else {
/* 143 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 144 */           }
/* 145 */
/* 146 */           // the hash map had be spilled, it should have enough memory now,
/* 147 */           // try  to allocate buffer again.
/* 148 */           agg_unsafeRowAggBuffer =
/* 149 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 150 */           if (agg_unsafeRowAggBuffer == null) {
/* 151 */             // failed to allocate the first page
/* 152 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 153 */           }
/* 154 */         }
/* 155 */       }
/* 156 */
/* 157 */       if (agg_fastAggBuffer != null) {
/* 158 */         // update fast row
/* 159 */
/* 160 */       } else {
/* 161 */         // update unsafe row
/* 162 */
/* 163 */         // common sub-expressions
/* 164 */
/* 165 */         // evaluate aggregate function
/* 166 */         boolean agg_isNull19 = true;
/* 167 */         long agg_value21 = -1L;
/* 168 */
/* 169 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 170 */         long agg_value23 = agg_isNull21 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 171 */         boolean agg_isNull20 = agg_isNull21;
/* 172 */         long agg_value22 = agg_value23;
/* 173 */         if (agg_isNull20) {
/* 174 */           boolean agg_isNull22 = false;
/* 175 */           long agg_value24 = -1L;
/* 176 */           if (!false) {
/* 177 */             agg_value24 = (long) 0;
/* 178 */           }
/* 179 */           if (!agg_isNull22) {
/* 180 */             agg_isNull20 = false;
/* 181 */             agg_value22 = agg_value24;
/* 182 */           }
/* 183 */         }
/* 184 */
/* 185 */         if (!inputadapter_isNull5) {
/* 186 */           agg_isNull19 = false; // resultCode could change nullability.
/* 187 */           agg_value21 = agg_value22 + inputadapter_value5;
/* 188 */
/* 189 */         }
/* 190 */         boolean agg_isNull18 = agg_isNull19;
/* 191 */         long agg_value20 = agg_value21;
/* 192 */         if (agg_isNull18) {
/* 193 */           boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 194 */           long agg_value27 = agg_isNull25 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 195 */           if (!agg_isNull25) {
/* 196 */             agg_isNull18 = false;
/* 197 */             agg_value20 = agg_value27;
/* 198 */           }
/* 199 */         }
/* 200 */         boolean agg_isNull27 = true;
/* 201 */         double agg_value29 = -1.0;
/* 202 */
/* 203 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 204 */         double agg_value31 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 205 */         boolean agg_isNull28 = agg_isNull29;
/* 206 */         double agg_value30 = agg_value31;
/* 207 */         if (agg_isNull28) {
/* 208 */           boolean agg_isNull30 = false;
/* 209 */           double agg_value32 = -1.0;
/* 210 */           if (!false) {
/* 211 */             agg_value32 = (double) 0;
/* 212 */           }
/* 213 */           if (!agg_isNull30) {
/* 214 */             agg_isNull28 = false;
/* 215 */             agg_value30 = agg_value32;
/* 216 */           }
/* 217 */         }
/* 218 */
/* 219 */         if (!inputadapter_isNull6) {
/* 220 */           agg_isNull27 = false; // resultCode could change nullability.
/* 221 */           agg_value29 = agg_value30 + inputadapter_value6;
/* 222 */
/* 223 */         }
/* 224 */         boolean agg_isNull26 = agg_isNull27;
/* 225 */         double agg_value28 = agg_value29;
/* 226 */         if (agg_isNull26) {
/* 227 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 228 */           double agg_value35 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 229 */           if (!agg_isNull33) {
/* 230 */             agg_isNull26 = false;
/* 231 */             agg_value28 = agg_value35;
/* 232 */           }
/* 233 */         }
/* 234 */         // update unsafe row buffer
/* 235 */         if (!agg_isNull18) {
/* 236 */           agg_unsafeRowAggBuffer.setLong(0, agg_value20);
/* 237 */         } else {
/* 238 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 239 */         }
/* 240 */
/* 241 */         if (!agg_isNull26) {
/* 242 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value28);
/* 243 */         } else {
/* 244 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 245 */         }
/* 246 */
/* 247 */       }
/* 248 */       if (shouldStop()) return;
/* 249 */     }
/* 250 */
/* 251 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 252 */   }
/* 253 */
/* 254 */   protected void processNext() throws java.io.IOException {
/* 255 */     if (!agg_initAgg) {
/* 256 */       agg_initAgg = true;
/* 257 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 258 */       agg_doAggregateWithKeys();
/* 259 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 260 */     }
/* 261 */
/* 262 */     // output the result
/* 263 */
/* 264 */     while (agg_mapIter.next()) {
/* 265 */       wholestagecodegen_numOutputRows.add(1);
/* 266 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 267 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 268 */
/* 269 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 270 */       int agg_value36 = agg_isNull34 ? -1 : (agg_aggKey.getInt(0));
/* 271 */       boolean agg_isNull35 = agg_aggKey.isNullAt(1);
/* 272 */       int agg_value37 = agg_isNull35 ? -1 : (agg_aggKey.getInt(1));
/* 273 */       boolean agg_isNull36 = agg_aggKey.isNullAt(2);
/* 274 */       int agg_value38 = agg_isNull36 ? -1 : (agg_aggKey.getInt(2));
/* 275 */       boolean agg_isNull37 = agg_aggKey.isNullAt(3);
/* 276 */       int agg_value39 = agg_isNull37 ? -1 : (agg_aggKey.getInt(3));
/* 277 */       boolean agg_isNull38 = agg_aggKey.isNullAt(4);
/* 278 */       int agg_value40 = agg_isNull38 ? -1 : (agg_aggKey.getInt(4));
/* 279 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(0);
/* 280 */       long agg_value41 = agg_isNull39 ? -1L : (agg_aggBuffer.getLong(0));
/* 281 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(1);
/* 282 */       double agg_value42 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 283 */
/* 284 */       agg_rowWriter1.zeroOutNullBytes();
/* 285 */
/* 286 */       if (agg_isNull34) {
/* 287 */         agg_rowWriter1.setNullAt(0);
/* 288 */       } else {
/* 289 */         agg_rowWriter1.write(0, agg_value36);
/* 290 */       }
/* 291 */
/* 292 */       if (agg_isNull35) {
/* 293 */         agg_rowWriter1.setNullAt(1);
/* 294 */       } else {
/* 295 */         agg_rowWriter1.write(1, agg_value37);
/* 296 */       }
/* 297 */
/* 298 */       if (agg_isNull36) {
/* 299 */         agg_rowWriter1.setNullAt(2);
/* 300 */       } else {
/* 301 */         agg_rowWriter1.write(2, agg_value38);
/* 302 */       }
/* 303 */
/* 304 */       if (agg_isNull37) {
/* 305 */         agg_rowWriter1.setNullAt(3);
/* 306 */       } else {
/* 307 */         agg_rowWriter1.write(3, agg_value39);
/* 308 */       }
/* 309 */
/* 310 */       if (agg_isNull38) {
/* 311 */         agg_rowWriter1.setNullAt(4);
/* 312 */       } else {
/* 313 */         agg_rowWriter1.write(4, agg_value40);
/* 314 */       }
/* 315 */
/* 316 */       if (agg_isNull39) {
/* 317 */         agg_rowWriter1.setNullAt(5);
/* 318 */       } else {
/* 319 */         agg_rowWriter1.write(5, agg_value41);
/* 320 */       }
/* 321 */
/* 322 */       if (agg_isNull40) {
/* 323 */         agg_rowWriter1.setNullAt(6);
/* 324 */       } else {
/* 325 */         agg_rowWriter1.write(6, agg_value42);
/* 326 */       }
/* 327 */       append(agg_result1);
/* 328 */
/* 329 */       if (shouldStop()) return;
/* 330 */     }
/* 331 */
/* 332 */     agg_mapIter.close();
/* 333 */     if (agg_sorter == null) {
/* 334 */       agg_hashMap.free();
/* 335 */     }
/* 336 */   }
/* 337 */ }
