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
/* 025 */   private int agg_value8;
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
/* 046 */     agg_result = new UnsafeRow(1);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(5);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 071 */
/* 072 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 073 */
/* 074 */       UnsafeRow agg_fastAggBuffer = null;
/* 075 */
/* 076 */       if (agg_fastAggBuffer == null) {
/* 077 */         // generate grouping key
/* 078 */         agg_holder.reset();
/* 079 */
/* 080 */         agg_rowWriter.zeroOutNullBytes();
/* 081 */
/* 082 */         if (inputadapter_isNull) {
/* 083 */           agg_rowWriter.setNullAt(0);
/* 084 */         } else {
/* 085 */           agg_rowWriter.write(0, inputadapter_value);
/* 086 */         }
/* 087 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 088 */         agg_value8 = 42;
/* 089 */
/* 090 */         if (!inputadapter_isNull) {
/* 091 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value8);
/* 092 */         }
/* 093 */         if (true) {
/* 094 */           // try to get the buffer from hash map
/* 095 */           agg_unsafeRowAggBuffer =
/* 096 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 097 */         }
/* 098 */         if (agg_unsafeRowAggBuffer == null) {
/* 099 */           if (agg_sorter == null) {
/* 100 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 101 */           } else {
/* 102 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 103 */           }
/* 104 */
/* 105 */           // the hash map had be spilled, it should have enough memory now,
/* 106 */           // try  to allocate buffer again.
/* 107 */           agg_unsafeRowAggBuffer =
/* 108 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 109 */           if (agg_unsafeRowAggBuffer == null) {
/* 110 */             // failed to allocate the first page
/* 111 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 112 */           }
/* 113 */         }
/* 114 */       }
/* 115 */
/* 116 */       if (agg_fastAggBuffer != null) {
/* 117 */         // update fast row
/* 118 */
/* 119 */       } else {
/* 120 */         // update unsafe row
/* 121 */
/* 122 */         // common sub-expressions
/* 123 */
/* 124 */         // evaluate aggregate function
/* 125 */         boolean agg_isNull8 = true;
/* 126 */         double agg_value11 = -1.0;
/* 127 */
/* 128 */         boolean agg_isNull10 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 129 */         double agg_value13 = agg_isNull10 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 130 */         boolean agg_isNull9 = agg_isNull10;
/* 131 */         double agg_value12 = agg_value13;
/* 132 */         if (agg_isNull9) {
/* 133 */           boolean agg_isNull11 = false;
/* 134 */           double agg_value14 = -1.0;
/* 135 */           if (!false) {
/* 136 */             agg_value14 = (double) 0;
/* 137 */           }
/* 138 */           if (!agg_isNull11) {
/* 139 */             agg_isNull9 = false;
/* 140 */             agg_value12 = agg_value14;
/* 141 */           }
/* 142 */         }
/* 143 */
/* 144 */         if (!inputadapter_isNull1) {
/* 145 */           agg_isNull8 = false; // resultCode could change nullability.
/* 146 */           agg_value11 = agg_value12 + inputadapter_value1;
/* 147 */
/* 148 */         }
/* 149 */         boolean agg_isNull7 = agg_isNull8;
/* 150 */         double agg_value10 = agg_value11;
/* 151 */         if (agg_isNull7) {
/* 152 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 153 */           double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 154 */           if (!agg_isNull14) {
/* 155 */             agg_isNull7 = false;
/* 156 */             agg_value10 = agg_value17;
/* 157 */           }
/* 158 */         }
/* 159 */         boolean agg_isNull16 = true;
/* 160 */         double agg_value19 = -1.0;
/* 161 */
/* 162 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 163 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 164 */         boolean agg_isNull17 = agg_isNull18;
/* 165 */         double agg_value20 = agg_value21;
/* 166 */         if (agg_isNull17) {
/* 167 */           boolean agg_isNull19 = false;
/* 168 */           double agg_value22 = -1.0;
/* 169 */           if (!false) {
/* 170 */             agg_value22 = (double) 0;
/* 171 */           }
/* 172 */           if (!agg_isNull19) {
/* 173 */             agg_isNull17 = false;
/* 174 */             agg_value20 = agg_value22;
/* 175 */           }
/* 176 */         }
/* 177 */
/* 178 */         if (!inputadapter_isNull2) {
/* 179 */           agg_isNull16 = false; // resultCode could change nullability.
/* 180 */           agg_value19 = agg_value20 + inputadapter_value2;
/* 181 */
/* 182 */         }
/* 183 */         boolean agg_isNull15 = agg_isNull16;
/* 184 */         double agg_value18 = agg_value19;
/* 185 */         if (agg_isNull15) {
/* 186 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 187 */           double agg_value25 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 188 */           if (!agg_isNull22) {
/* 189 */             agg_isNull15 = false;
/* 190 */             agg_value18 = agg_value25;
/* 191 */           }
/* 192 */         }
/* 193 */         boolean agg_isNull24 = true;
/* 194 */         double agg_value27 = -1.0;
/* 195 */
/* 196 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 197 */         double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 198 */         boolean agg_isNull25 = agg_isNull26;
/* 199 */         double agg_value28 = agg_value29;
/* 200 */         if (agg_isNull25) {
/* 201 */           boolean agg_isNull27 = false;
/* 202 */           double agg_value30 = -1.0;
/* 203 */           if (!false) {
/* 204 */             agg_value30 = (double) 0;
/* 205 */           }
/* 206 */           if (!agg_isNull27) {
/* 207 */             agg_isNull25 = false;
/* 208 */             agg_value28 = agg_value30;
/* 209 */           }
/* 210 */         }
/* 211 */
/* 212 */         if (!inputadapter_isNull3) {
/* 213 */           agg_isNull24 = false; // resultCode could change nullability.
/* 214 */           agg_value27 = agg_value28 + inputadapter_value3;
/* 215 */
/* 216 */         }
/* 217 */         boolean agg_isNull23 = agg_isNull24;
/* 218 */         double agg_value26 = agg_value27;
/* 219 */         if (agg_isNull23) {
/* 220 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 221 */           double agg_value33 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 222 */           if (!agg_isNull30) {
/* 223 */             agg_isNull23 = false;
/* 224 */             agg_value26 = agg_value33;
/* 225 */           }
/* 226 */         }
/* 227 */         // update unsafe row buffer
/* 228 */         if (!agg_isNull7) {
/* 229 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value10);
/* 230 */         } else {
/* 231 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 232 */         }
/* 233 */
/* 234 */         if (!agg_isNull15) {
/* 235 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value18);
/* 236 */         } else {
/* 237 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 238 */         }
/* 239 */
/* 240 */         if (!agg_isNull23) {
/* 241 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value26);
/* 242 */         } else {
/* 243 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 244 */         }
/* 245 */
/* 246 */       }
/* 247 */       if (shouldStop()) return;
/* 248 */     }
/* 249 */
/* 250 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 251 */   }
/* 252 */
/* 253 */   protected void processNext() throws java.io.IOException {
/* 254 */     if (!agg_initAgg) {
/* 255 */       agg_initAgg = true;
/* 256 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 257 */       agg_doAggregateWithKeys();
/* 258 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 259 */     }
/* 260 */
/* 261 */     // output the result
/* 262 */
/* 263 */     while (agg_mapIter.next()) {
/* 264 */       wholestagecodegen_numOutputRows.add(1);
/* 265 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 266 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 267 */
/* 268 */       boolean agg_isNull31 = agg_aggKey.isNullAt(0);
/* 269 */       UTF8String agg_value34 = agg_isNull31 ? null : (agg_aggKey.getUTF8String(0));
/* 270 */       boolean agg_isNull32 = agg_aggBuffer.isNullAt(0);
/* 271 */       double agg_value35 = agg_isNull32 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 272 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(1);
/* 273 */       double agg_value36 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 274 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(2);
/* 275 */       double agg_value37 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 276 */
/* 277 */       boolean agg_isNull42 = false;
/* 278 */       UTF8String agg_value45 = UTF8String.concat(false ? null : ((UTF8String) references[4]), agg_isNull31 ? null : agg_value34);
/* 279 */       if (agg_value45 == null) {
/* 280 */         agg_isNull42 = true;
/* 281 */       }
/* 282 */       agg_holder1.reset();
/* 283 */
/* 284 */       agg_rowWriter1.zeroOutNullBytes();
/* 285 */
/* 286 */       if (agg_isNull32) {
/* 287 */         agg_rowWriter1.setNullAt(0);
/* 288 */       } else {
/* 289 */         agg_rowWriter1.write(0, agg_value35);
/* 290 */       }
/* 291 */
/* 292 */       if (agg_isNull33) {
/* 293 */         agg_rowWriter1.setNullAt(1);
/* 294 */       } else {
/* 295 */         agg_rowWriter1.write(1, agg_value36);
/* 296 */       }
/* 297 */
/* 298 */       if (agg_isNull34) {
/* 299 */         agg_rowWriter1.setNullAt(2);
/* 300 */       } else {
/* 301 */         agg_rowWriter1.write(2, agg_value37);
/* 302 */       }
/* 303 */
/* 304 */       agg_rowWriter1.write(3, ((UTF8String) references[3]));
/* 305 */
/* 306 */       if (agg_isNull42) {
/* 307 */         agg_rowWriter1.setNullAt(4);
/* 308 */       } else {
/* 309 */         agg_rowWriter1.write(4, agg_value45);
/* 310 */       }
/* 311 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 312 */       append(agg_result1);
/* 313 */
/* 314 */       if (shouldStop()) return;
/* 315 */     }
/* 316 */
/* 317 */     agg_mapIter.close();
/* 318 */     if (agg_sorter == null) {
/* 319 */       agg_hashMap.free();
/* 320 */     }
/* 321 */   }
/* 322 */ }
