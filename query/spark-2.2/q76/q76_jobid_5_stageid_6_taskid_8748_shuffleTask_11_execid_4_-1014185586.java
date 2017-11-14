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
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(7);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
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
/* 061 */       UTF8String inputadapter_value = inputadapter_row.getUTF8String(0);
/* 062 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 063 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 064 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 065 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 066 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 067 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 068 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 069 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 070 */       long inputadapter_value5 = inputadapter_row.getLong(5);
/* 071 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 072 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 073 */
/* 074 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 075 */
/* 076 */       UnsafeRow agg_fastAggBuffer = null;
/* 077 */
/* 078 */       if (agg_fastAggBuffer == null) {
/* 079 */         // generate grouping key
/* 080 */         agg_holder.reset();
/* 081 */
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         agg_rowWriter.write(0, inputadapter_value);
/* 085 */
/* 086 */         if (inputadapter_isNull1) {
/* 087 */           agg_rowWriter.setNullAt(1);
/* 088 */         } else {
/* 089 */           agg_rowWriter.write(1, inputadapter_value1);
/* 090 */         }
/* 091 */
/* 092 */         if (inputadapter_isNull2) {
/* 093 */           agg_rowWriter.setNullAt(2);
/* 094 */         } else {
/* 095 */           agg_rowWriter.write(2, inputadapter_value2);
/* 096 */         }
/* 097 */
/* 098 */         if (inputadapter_isNull3) {
/* 099 */           agg_rowWriter.setNullAt(3);
/* 100 */         } else {
/* 101 */           agg_rowWriter.write(3, inputadapter_value3);
/* 102 */         }
/* 103 */
/* 104 */         if (inputadapter_isNull4) {
/* 105 */           agg_rowWriter.setNullAt(4);
/* 106 */         } else {
/* 107 */           agg_rowWriter.write(4, inputadapter_value4);
/* 108 */         }
/* 109 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 110 */         agg_value14 = 42;
/* 111 */
/* 112 */         agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 113 */
/* 114 */         if (!inputadapter_isNull1) {
/* 115 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull2) {
/* 119 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull3) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull4) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value14);
/* 128 */         }
/* 129 */         if (true) {
/* 130 */           // try to get the buffer from hash map
/* 131 */           agg_unsafeRowAggBuffer =
/* 132 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 133 */         }
/* 134 */         if (agg_unsafeRowAggBuffer == null) {
/* 135 */           if (agg_sorter == null) {
/* 136 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 137 */           } else {
/* 138 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 139 */           }
/* 140 */
/* 141 */           // the hash map had be spilled, it should have enough memory now,
/* 142 */           // try  to allocate buffer again.
/* 143 */           agg_unsafeRowAggBuffer =
/* 144 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 145 */           if (agg_unsafeRowAggBuffer == null) {
/* 146 */             // failed to allocate the first page
/* 147 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 148 */           }
/* 149 */         }
/* 150 */       }
/* 151 */
/* 152 */       if (agg_fastAggBuffer != null) {
/* 153 */         // update fast row
/* 154 */
/* 155 */       } else {
/* 156 */         // update unsafe row
/* 157 */
/* 158 */         // common sub-expressions
/* 159 */
/* 160 */         // evaluate aggregate function
/* 161 */         boolean agg_isNull18 = false;
/* 162 */
/* 163 */         long agg_value21 = agg_unsafeRowAggBuffer.getLong(0);
/* 164 */
/* 165 */         long agg_value20 = -1L;
/* 166 */         agg_value20 = agg_value21 + inputadapter_value5;
/* 167 */         boolean agg_isNull22 = true;
/* 168 */         double agg_value24 = -1.0;
/* 169 */
/* 170 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 171 */         double agg_value26 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 172 */         boolean agg_isNull23 = agg_isNull24;
/* 173 */         double agg_value25 = agg_value26;
/* 174 */         if (agg_isNull23) {
/* 175 */           boolean agg_isNull25 = false;
/* 176 */           double agg_value27 = -1.0;
/* 177 */           if (!false) {
/* 178 */             agg_value27 = (double) 0;
/* 179 */           }
/* 180 */           if (!agg_isNull25) {
/* 181 */             agg_isNull23 = false;
/* 182 */             agg_value25 = agg_value27;
/* 183 */           }
/* 184 */         }
/* 185 */
/* 186 */         if (!inputadapter_isNull6) {
/* 187 */           agg_isNull22 = false; // resultCode could change nullability.
/* 188 */           agg_value24 = agg_value25 + inputadapter_value6;
/* 189 */
/* 190 */         }
/* 191 */         boolean agg_isNull21 = agg_isNull22;
/* 192 */         double agg_value23 = agg_value24;
/* 193 */         if (agg_isNull21) {
/* 194 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 195 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 196 */           if (!agg_isNull28) {
/* 197 */             agg_isNull21 = false;
/* 198 */             agg_value23 = agg_value30;
/* 199 */           }
/* 200 */         }
/* 201 */         // update unsafe row buffer
/* 202 */         agg_unsafeRowAggBuffer.setLong(0, agg_value20);
/* 203 */
/* 204 */         if (!agg_isNull21) {
/* 205 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value23);
/* 206 */         } else {
/* 207 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 208 */         }
/* 209 */
/* 210 */       }
/* 211 */       if (shouldStop()) return;
/* 212 */     }
/* 213 */
/* 214 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 215 */   }
/* 216 */
/* 217 */   protected void processNext() throws java.io.IOException {
/* 218 */     if (!agg_initAgg) {
/* 219 */       agg_initAgg = true;
/* 220 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 221 */       agg_doAggregateWithKeys();
/* 222 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 223 */     }
/* 224 */
/* 225 */     // output the result
/* 226 */
/* 227 */     while (agg_mapIter.next()) {
/* 228 */       wholestagecodegen_numOutputRows.add(1);
/* 229 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 230 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 231 */
/* 232 */       UTF8String agg_value31 = agg_aggKey.getUTF8String(0);
/* 233 */       boolean agg_isNull30 = agg_aggKey.isNullAt(1);
/* 234 */       int agg_value32 = agg_isNull30 ? -1 : (agg_aggKey.getInt(1));
/* 235 */       boolean agg_isNull31 = agg_aggKey.isNullAt(2);
/* 236 */       int agg_value33 = agg_isNull31 ? -1 : (agg_aggKey.getInt(2));
/* 237 */       boolean agg_isNull32 = agg_aggKey.isNullAt(3);
/* 238 */       int agg_value34 = agg_isNull32 ? -1 : (agg_aggKey.getInt(3));
/* 239 */       boolean agg_isNull33 = agg_aggKey.isNullAt(4);
/* 240 */       UTF8String agg_value35 = agg_isNull33 ? null : (agg_aggKey.getUTF8String(4));
/* 241 */       long agg_value36 = agg_aggBuffer.getLong(0);
/* 242 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(1);
/* 243 */       double agg_value37 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 244 */
/* 245 */       agg_holder1.reset();
/* 246 */
/* 247 */       agg_rowWriter1.zeroOutNullBytes();
/* 248 */
/* 249 */       agg_rowWriter1.write(0, agg_value31);
/* 250 */
/* 251 */       if (agg_isNull30) {
/* 252 */         agg_rowWriter1.setNullAt(1);
/* 253 */       } else {
/* 254 */         agg_rowWriter1.write(1, agg_value32);
/* 255 */       }
/* 256 */
/* 257 */       if (agg_isNull31) {
/* 258 */         agg_rowWriter1.setNullAt(2);
/* 259 */       } else {
/* 260 */         agg_rowWriter1.write(2, agg_value33);
/* 261 */       }
/* 262 */
/* 263 */       if (agg_isNull32) {
/* 264 */         agg_rowWriter1.setNullAt(3);
/* 265 */       } else {
/* 266 */         agg_rowWriter1.write(3, agg_value34);
/* 267 */       }
/* 268 */
/* 269 */       if (agg_isNull33) {
/* 270 */         agg_rowWriter1.setNullAt(4);
/* 271 */       } else {
/* 272 */         agg_rowWriter1.write(4, agg_value35);
/* 273 */       }
/* 274 */
/* 275 */       agg_rowWriter1.write(5, agg_value36);
/* 276 */
/* 277 */       if (agg_isNull35) {
/* 278 */         agg_rowWriter1.setNullAt(6);
/* 279 */       } else {
/* 280 */         agg_rowWriter1.write(6, agg_value37);
/* 281 */       }
/* 282 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 283 */       append(agg_result1);
/* 284 */
/* 285 */       if (shouldStop()) return;
/* 286 */     }
/* 287 */
/* 288 */     agg_mapIter.close();
/* 289 */     if (agg_sorter == null) {
/* 290 */       agg_hashMap.free();
/* 291 */     }
/* 292 */   }
/* 293 */ }
