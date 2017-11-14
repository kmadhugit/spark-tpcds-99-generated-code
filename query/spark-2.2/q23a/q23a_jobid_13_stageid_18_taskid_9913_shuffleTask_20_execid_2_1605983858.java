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
/* 021 */   private int agg_value8;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     wholestagecodegen_init_0();
/* 043 */     wholestagecodegen_init_1();
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private void wholestagecodegen_init_0() {
/* 048 */     agg_initAgg = false;
/* 049 */
/* 050 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 051 */
/* 052 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     inputadapter_input = inputs[0];
/* 055 */     agg_result = new UnsafeRow(3);
/* 056 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 057 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 058 */
/* 059 */     agg_result1 = new UnsafeRow(2);
/* 060 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 061 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 062 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 063 */     filter_result = new UnsafeRow(2);
/* 064 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 069 */     agg_hashMap = agg_plan.createHashMap();
/* 070 */
/* 071 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 072 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 073 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 074 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 075 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 076 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 077 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 078 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 079 */       long inputadapter_value3 = inputadapter_row.getLong(3);
/* 080 */
/* 081 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 082 */
/* 083 */       UnsafeRow agg_fastAggBuffer = null;
/* 084 */
/* 085 */       if (agg_fastAggBuffer == null) {
/* 086 */         // generate grouping key
/* 087 */         agg_holder.reset();
/* 088 */
/* 089 */         agg_rowWriter.zeroOutNullBytes();
/* 090 */
/* 091 */         if (inputadapter_isNull) {
/* 092 */           agg_rowWriter.setNullAt(0);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(0, inputadapter_value);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull1) {
/* 098 */           agg_rowWriter.setNullAt(1);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(1, inputadapter_value1);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull2) {
/* 104 */           agg_rowWriter.setNullAt(2);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(2, inputadapter_value2);
/* 107 */         }
/* 108 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 109 */         agg_value8 = 42;
/* 110 */
/* 111 */         if (!inputadapter_isNull) {
/* 112 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value8);
/* 113 */         }
/* 114 */
/* 115 */         if (!inputadapter_isNull1) {
/* 116 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value8);
/* 117 */         }
/* 118 */
/* 119 */         if (!inputadapter_isNull2) {
/* 120 */           agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value8);
/* 121 */         }
/* 122 */         if (true) {
/* 123 */           // try to get the buffer from hash map
/* 124 */           agg_unsafeRowAggBuffer =
/* 125 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 126 */         }
/* 127 */         if (agg_unsafeRowAggBuffer == null) {
/* 128 */           if (agg_sorter == null) {
/* 129 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 130 */           } else {
/* 131 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 132 */           }
/* 133 */
/* 134 */           // the hash map had be spilled, it should have enough memory now,
/* 135 */           // try  to allocate buffer again.
/* 136 */           agg_unsafeRowAggBuffer =
/* 137 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value8);
/* 138 */           if (agg_unsafeRowAggBuffer == null) {
/* 139 */             // failed to allocate the first page
/* 140 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 141 */           }
/* 142 */         }
/* 143 */       }
/* 144 */
/* 145 */       if (agg_fastAggBuffer != null) {
/* 146 */         // update fast row
/* 147 */
/* 148 */       } else {
/* 149 */         // update unsafe row
/* 150 */
/* 151 */         // common sub-expressions
/* 152 */
/* 153 */         // evaluate aggregate function
/* 154 */         boolean agg_isNull11 = false;
/* 155 */
/* 156 */         long agg_value13 = agg_unsafeRowAggBuffer.getLong(0);
/* 157 */
/* 158 */         long agg_value12 = -1L;
/* 159 */         agg_value12 = agg_value13 + inputadapter_value3;
/* 160 */         // update unsafe row buffer
/* 161 */         agg_unsafeRowAggBuffer.setLong(0, agg_value12);
/* 162 */
/* 163 */       }
/* 164 */       if (shouldStop()) return;
/* 165 */     }
/* 166 */
/* 167 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 168 */   }
/* 169 */
/* 170 */   private void wholestagecodegen_init_1() {
/* 171 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 172 */     project_result = new UnsafeRow(1);
/* 173 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 174 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 175 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 176 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 177 */
/* 178 */   }
/* 179 */
/* 180 */   protected void processNext() throws java.io.IOException {
/* 181 */     if (!agg_initAgg) {
/* 182 */       agg_initAgg = true;
/* 183 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 184 */       agg_doAggregateWithKeys();
/* 185 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 186 */     }
/* 187 */
/* 188 */     // output the result
/* 189 */
/* 190 */     while (agg_mapIter.next()) {
/* 191 */       wholestagecodegen_numOutputRows.add(1);
/* 192 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 193 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 194 */
/* 195 */       boolean agg_isNull14 = agg_aggKey.isNullAt(0);
/* 196 */       UTF8String agg_value15 = agg_isNull14 ? null : (agg_aggKey.getUTF8String(0));
/* 197 */       boolean agg_isNull15 = agg_aggKey.isNullAt(1);
/* 198 */       int agg_value16 = agg_isNull15 ? -1 : (agg_aggKey.getInt(1));
/* 199 */       boolean agg_isNull16 = agg_aggKey.isNullAt(2);
/* 200 */       UTF8String agg_value17 = agg_isNull16 ? null : (agg_aggKey.getUTF8String(2));
/* 201 */       long agg_value18 = agg_aggBuffer.getLong(0);
/* 202 */
/* 203 */       boolean filter_isNull = false;
/* 204 */
/* 205 */       boolean filter_value = false;
/* 206 */       filter_value = agg_value18 > 4L;
/* 207 */       if (!filter_value) continue;
/* 208 */
/* 209 */       filter_numOutputRows.add(1);
/* 210 */
/* 211 */       project_rowWriter.zeroOutNullBytes();
/* 212 */
/* 213 */       if (agg_isNull15) {
/* 214 */         project_rowWriter.setNullAt(0);
/* 215 */       } else {
/* 216 */         project_rowWriter.write(0, agg_value16);
/* 217 */       }
/* 218 */       append(project_result);
/* 219 */
/* 220 */       if (shouldStop()) return;
/* 221 */     }
/* 222 */
/* 223 */     agg_mapIter.close();
/* 224 */     if (agg_sorter == null) {
/* 225 */       agg_hashMap.free();
/* 226 */     }
/* 227 */   }
/* 228 */ }
