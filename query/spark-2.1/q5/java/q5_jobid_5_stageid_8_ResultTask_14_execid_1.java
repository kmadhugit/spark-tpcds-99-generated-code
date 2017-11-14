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
/* 025 */   private int agg_value12;
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
/* 046 */     agg_result = new UnsafeRow(3);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(5);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
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
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 067 */       int inputadapter_value2 = inputadapter_row.getInt(2);
/* 068 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 069 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 070 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 071 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 072 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 073 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 074 */
/* 075 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 076 */
/* 077 */       UnsafeRow agg_fastAggBuffer = null;
/* 078 */
/* 079 */       if (agg_fastAggBuffer == null) {
/* 080 */         // generate grouping key
/* 081 */         agg_holder.reset();
/* 082 */
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull1) {
/* 092 */           agg_rowWriter.setNullAt(1);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(1, inputadapter_value1);
/* 095 */         }
/* 096 */
/* 097 */         agg_rowWriter.write(2, inputadapter_value2);
/* 098 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 099 */         agg_value12 = 42;
/* 100 */
/* 101 */         if (!inputadapter_isNull) {
/* 102 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value12);
/* 103 */         }
/* 104 */
/* 105 */         if (!inputadapter_isNull1) {
/* 106 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value12);
/* 107 */         }
/* 108 */
/* 109 */         agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 110 */         if (true) {
/* 111 */           // try to get the buffer from hash map
/* 112 */           agg_unsafeRowAggBuffer =
/* 113 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 114 */         }
/* 115 */         if (agg_unsafeRowAggBuffer == null) {
/* 116 */           if (agg_sorter == null) {
/* 117 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 118 */           } else {
/* 119 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 120 */           }
/* 121 */
/* 122 */           // the hash map had be spilled, it should have enough memory now,
/* 123 */           // try  to allocate buffer again.
/* 124 */           agg_unsafeRowAggBuffer =
/* 125 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 126 */           if (agg_unsafeRowAggBuffer == null) {
/* 127 */             // failed to allocate the first page
/* 128 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 129 */           }
/* 130 */         }
/* 131 */       }
/* 132 */
/* 133 */       if (agg_fastAggBuffer != null) {
/* 134 */         // update fast row
/* 135 */
/* 136 */       } else {
/* 137 */         // update unsafe row
/* 138 */
/* 139 */         // common sub-expressions
/* 140 */         boolean agg_isNull13 = false;
/* 141 */         double agg_value16 = -1.0;
/* 142 */         if (!false) {
/* 143 */           agg_value16 = (double) 0;
/* 144 */         }
/* 145 */         // evaluate aggregate function
/* 146 */         boolean agg_isNull16 = true;
/* 147 */         double agg_value19 = -1.0;
/* 148 */
/* 149 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 150 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 151 */         boolean agg_isNull17 = agg_isNull18;
/* 152 */         double agg_value20 = agg_value21;
/* 153 */         if (agg_isNull17) {
/* 154 */           if (!agg_isNull13) {
/* 155 */             agg_isNull17 = false;
/* 156 */             agg_value20 = agg_value16;
/* 157 */           }
/* 158 */         }
/* 159 */
/* 160 */         if (!inputadapter_isNull3) {
/* 161 */           agg_isNull16 = false; // resultCode could change nullability.
/* 162 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 163 */
/* 164 */         }
/* 165 */         boolean agg_isNull15 = agg_isNull16;
/* 166 */         double agg_value18 = agg_value19;
/* 167 */         if (agg_isNull15) {
/* 168 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 169 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 170 */           if (!agg_isNull20) {
/* 171 */             agg_isNull15 = false;
/* 172 */             agg_value18 = agg_value23;
/* 173 */           }
/* 174 */         }
/* 175 */         boolean agg_isNull22 = true;
/* 176 */         double agg_value25 = -1.0;
/* 177 */
/* 178 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 179 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 180 */         boolean agg_isNull23 = agg_isNull24;
/* 181 */         double agg_value26 = agg_value27;
/* 182 */         if (agg_isNull23) {
/* 183 */           if (!agg_isNull13) {
/* 184 */             agg_isNull23 = false;
/* 185 */             agg_value26 = agg_value16;
/* 186 */           }
/* 187 */         }
/* 188 */
/* 189 */         if (!inputadapter_isNull4) {
/* 190 */           agg_isNull22 = false; // resultCode could change nullability.
/* 191 */           agg_value25 = agg_value26 + inputadapter_value4;
/* 192 */
/* 193 */         }
/* 194 */         boolean agg_isNull21 = agg_isNull22;
/* 195 */         double agg_value24 = agg_value25;
/* 196 */         if (agg_isNull21) {
/* 197 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 198 */           double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 199 */           if (!agg_isNull26) {
/* 200 */             agg_isNull21 = false;
/* 201 */             agg_value24 = agg_value29;
/* 202 */           }
/* 203 */         }
/* 204 */         boolean agg_isNull28 = true;
/* 205 */         double agg_value31 = -1.0;
/* 206 */
/* 207 */         boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 208 */         double agg_value33 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 209 */         boolean agg_isNull29 = agg_isNull30;
/* 210 */         double agg_value32 = agg_value33;
/* 211 */         if (agg_isNull29) {
/* 212 */           if (!agg_isNull13) {
/* 213 */             agg_isNull29 = false;
/* 214 */             agg_value32 = agg_value16;
/* 215 */           }
/* 216 */         }
/* 217 */
/* 218 */         if (!inputadapter_isNull5) {
/* 219 */           agg_isNull28 = false; // resultCode could change nullability.
/* 220 */           agg_value31 = agg_value32 + inputadapter_value5;
/* 221 */
/* 222 */         }
/* 223 */         boolean agg_isNull27 = agg_isNull28;
/* 224 */         double agg_value30 = agg_value31;
/* 225 */         if (agg_isNull27) {
/* 226 */           boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 227 */           double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 228 */           if (!agg_isNull32) {
/* 229 */             agg_isNull27 = false;
/* 230 */             agg_value30 = agg_value35;
/* 231 */           }
/* 232 */         }
/* 233 */         // update unsafe row buffer
/* 234 */         if (!agg_isNull15) {
/* 235 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 236 */         } else {
/* 237 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 238 */         }
/* 239 */
/* 240 */         if (!agg_isNull21) {
/* 241 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 242 */         } else {
/* 243 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 244 */         }
/* 245 */
/* 246 */         if (!agg_isNull27) {
/* 247 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value30);
/* 248 */         } else {
/* 249 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 250 */         }
/* 251 */
/* 252 */       }
/* 253 */       if (shouldStop()) return;
/* 254 */     }
/* 255 */
/* 256 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 257 */   }
/* 258 */
/* 259 */   protected void processNext() throws java.io.IOException {
/* 260 */     if (!agg_initAgg) {
/* 261 */       agg_initAgg = true;
/* 262 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 263 */       agg_doAggregateWithKeys();
/* 264 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 265 */     }
/* 266 */
/* 267 */     // output the result
/* 268 */
/* 269 */     while (agg_mapIter.next()) {
/* 270 */       wholestagecodegen_numOutputRows.add(1);
/* 271 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 272 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 273 */
/* 274 */       boolean agg_isNull33 = agg_aggKey.isNullAt(0);
/* 275 */       UTF8String agg_value36 = agg_isNull33 ? null : (agg_aggKey.getUTF8String(0));
/* 276 */       boolean agg_isNull34 = agg_aggKey.isNullAt(1);
/* 277 */       UTF8String agg_value37 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(1));
/* 278 */       int agg_value38 = agg_aggKey.getInt(2);
/* 279 */       boolean agg_isNull36 = agg_aggBuffer.isNullAt(0);
/* 280 */       double agg_value39 = agg_isNull36 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 281 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(1);
/* 282 */       double agg_value40 = agg_isNull37 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 283 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(2);
/* 284 */       double agg_value41 = agg_isNull38 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 285 */
/* 286 */       agg_holder1.reset();
/* 287 */
/* 288 */       agg_rowWriter1.zeroOutNullBytes();
/* 289 */
/* 290 */       if (agg_isNull33) {
/* 291 */         agg_rowWriter1.setNullAt(0);
/* 292 */       } else {
/* 293 */         agg_rowWriter1.write(0, agg_value36);
/* 294 */       }
/* 295 */
/* 296 */       if (agg_isNull34) {
/* 297 */         agg_rowWriter1.setNullAt(1);
/* 298 */       } else {
/* 299 */         agg_rowWriter1.write(1, agg_value37);
/* 300 */       }
/* 301 */
/* 302 */       if (agg_isNull36) {
/* 303 */         agg_rowWriter1.setNullAt(2);
/* 304 */       } else {
/* 305 */         agg_rowWriter1.write(2, agg_value39);
/* 306 */       }
/* 307 */
/* 308 */       if (agg_isNull37) {
/* 309 */         agg_rowWriter1.setNullAt(3);
/* 310 */       } else {
/* 311 */         agg_rowWriter1.write(3, agg_value40);
/* 312 */       }
/* 313 */
/* 314 */       if (agg_isNull38) {
/* 315 */         agg_rowWriter1.setNullAt(4);
/* 316 */       } else {
/* 317 */         agg_rowWriter1.write(4, agg_value41);
/* 318 */       }
/* 319 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 320 */       append(agg_result1);
/* 321 */
/* 322 */       if (shouldStop()) return;
/* 323 */     }
/* 324 */
/* 325 */     agg_mapIter.close();
/* 326 */     if (agg_sorter == null) {
/* 327 */       agg_hashMap.free();
/* 328 */     }
/* 329 */   }
/* 330 */ }
