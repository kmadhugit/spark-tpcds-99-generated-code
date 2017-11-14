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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value6;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
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
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(2);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(3);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(3);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       long inputadapter_value = inputadapter_isNull ? -1L : (inputadapter_row.getLong(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 074 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 075 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 076 */
/* 077 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 078 */
/* 079 */       UnsafeRow agg_fastAggBuffer = null;
/* 080 */
/* 081 */       if (agg_fastAggBuffer == null) {
/* 082 */         // generate grouping key
/* 083 */         agg_holder.reset();
/* 084 */
/* 085 */         agg_rowWriter.zeroOutNullBytes();
/* 086 */
/* 087 */         if (inputadapter_isNull) {
/* 088 */           agg_rowWriter.setNullAt(0);
/* 089 */         } else {
/* 090 */           agg_rowWriter.write(0, inputadapter_value);
/* 091 */         }
/* 092 */
/* 093 */         if (inputadapter_isNull1) {
/* 094 */           agg_rowWriter.setNullAt(1);
/* 095 */         } else {
/* 096 */           agg_rowWriter.write(1, inputadapter_value1);
/* 097 */         }
/* 098 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 099 */         agg_value6 = 42;
/* 100 */
/* 101 */         if (!inputadapter_isNull) {
/* 102 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(inputadapter_value, agg_value6);
/* 103 */         }
/* 104 */
/* 105 */         if (!inputadapter_isNull1) {
/* 106 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value6);
/* 107 */         }
/* 108 */         if (true) {
/* 109 */           // try to get the buffer from hash map
/* 110 */           agg_unsafeRowAggBuffer =
/* 111 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 112 */         }
/* 113 */         if (agg_unsafeRowAggBuffer == null) {
/* 114 */           if (agg_sorter == null) {
/* 115 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 116 */           } else {
/* 117 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 118 */           }
/* 119 */
/* 120 */           // the hash map had be spilled, it should have enough memory now,
/* 121 */           // try  to allocate buffer again.
/* 122 */           agg_unsafeRowAggBuffer =
/* 123 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 124 */           if (agg_unsafeRowAggBuffer == null) {
/* 125 */             // failed to allocate the first page
/* 126 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 127 */           }
/* 128 */         }
/* 129 */       }
/* 130 */
/* 131 */       if (agg_fastAggBuffer != null) {
/* 132 */         // update fast row
/* 133 */
/* 134 */       } else {
/* 135 */         // update unsafe row
/* 136 */
/* 137 */         // common sub-expressions
/* 138 */
/* 139 */         // evaluate aggregate function
/* 140 */         boolean agg_isNull9 = true;
/* 141 */         double agg_value10 = -1.0;
/* 142 */
/* 143 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 144 */         double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 145 */         boolean agg_isNull10 = agg_isNull11;
/* 146 */         double agg_value11 = agg_value12;
/* 147 */         if (agg_isNull10) {
/* 148 */           boolean agg_isNull12 = false;
/* 149 */           double agg_value13 = -1.0;
/* 150 */           if (!false) {
/* 151 */             agg_value13 = (double) 0;
/* 152 */           }
/* 153 */           if (!agg_isNull12) {
/* 154 */             agg_isNull10 = false;
/* 155 */             agg_value11 = agg_value13;
/* 156 */           }
/* 157 */         }
/* 158 */
/* 159 */         if (!inputadapter_isNull2) {
/* 160 */           agg_isNull9 = false; // resultCode could change nullability.
/* 161 */           agg_value10 = agg_value11 + inputadapter_value2;
/* 162 */
/* 163 */         }
/* 164 */         boolean agg_isNull8 = agg_isNull9;
/* 165 */         double agg_value9 = agg_value10;
/* 166 */         if (agg_isNull8) {
/* 167 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 168 */           double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 169 */           if (!agg_isNull15) {
/* 170 */             agg_isNull8 = false;
/* 171 */             agg_value9 = agg_value16;
/* 172 */           }
/* 173 */         }
/* 174 */         // update unsafe row buffer
/* 175 */         if (!agg_isNull8) {
/* 176 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 177 */         } else {
/* 178 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 179 */         }
/* 180 */
/* 181 */       }
/* 182 */       if (shouldStop()) return;
/* 183 */     }
/* 184 */
/* 185 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 186 */   }
/* 187 */
/* 188 */   private void wholestagecodegen_init_1() {
/* 189 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 190 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 191 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 192 */
/* 193 */   }
/* 194 */
/* 195 */   protected void processNext() throws java.io.IOException {
/* 196 */     if (!agg_initAgg) {
/* 197 */       agg_initAgg = true;
/* 198 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 199 */       agg_doAggregateWithKeys();
/* 200 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 201 */     }
/* 202 */
/* 203 */     // output the result
/* 204 */
/* 205 */     while (agg_mapIter.next()) {
/* 206 */       wholestagecodegen_numOutputRows.add(1);
/* 207 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 208 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 209 */
/* 210 */       boolean agg_isNull16 = agg_aggKey.isNullAt(0);
/* 211 */       long agg_value17 = agg_isNull16 ? -1L : (agg_aggKey.getLong(0));
/* 212 */       boolean agg_isNull17 = agg_aggKey.isNullAt(1);
/* 213 */       UTF8String agg_value18 = agg_isNull17 ? null : (agg_aggKey.getUTF8String(1));
/* 214 */       boolean agg_isNull18 = agg_aggBuffer.isNullAt(0);
/* 215 */       double agg_value19 = agg_isNull18 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 216 */
/* 217 */       if (!(!(agg_isNull18))) continue;
/* 218 */
/* 219 */       filter_numOutputRows.add(1);
/* 220 */
/* 221 */       filter_holder.reset();
/* 222 */
/* 223 */       filter_rowWriter.zeroOutNullBytes();
/* 224 */
/* 225 */       if (agg_isNull16) {
/* 226 */         filter_rowWriter.setNullAt(0);
/* 227 */       } else {
/* 228 */         filter_rowWriter.write(0, agg_value17);
/* 229 */       }
/* 230 */
/* 231 */       if (agg_isNull17) {
/* 232 */         filter_rowWriter.setNullAt(1);
/* 233 */       } else {
/* 234 */         filter_rowWriter.write(1, agg_value18);
/* 235 */       }
/* 236 */
/* 237 */       filter_rowWriter.write(2, agg_value19);
/* 238 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 239 */       append(filter_result);
/* 240 */
/* 241 */       if (shouldStop()) return;
/* 242 */     }
/* 243 */
/* 244 */     agg_mapIter.close();
/* 245 */     if (agg_sorter == null) {
/* 246 */       agg_hashMap.free();
/* 247 */     }
/* 248 */   }
/* 249 */ }
