/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(0);
/* 026 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     UTF8String primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(0);
/* 036 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 037 */       isNullB = isNull;
/* 038 */       primitiveB = value;
/* 039 */     }
/* 040 */     if (isNullA && isNullB) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA.compare(primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     UTF8String primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(1);
/* 060 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     UTF8String primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(1);
/* 070 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return -1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return 1;
/* 080 */     } else {
/* 081 */       int comp = primitiveA1.compare(primitiveB1);
/* 082 */       if (comp != 0) {
/* 083 */         return comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     i = a;
/* 089 */     boolean isNullA2;
/* 090 */     UTF8String primitiveA2;
/* 091 */     {
/* 092 */
/* 093 */       boolean isNull2 = true;
/* 094 */       UTF8String value2 = null;
/* 095 */
/* 096 */       boolean isNull3 = i.isNullAt(6);
/* 097 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(6));
/* 098 */       if (!isNull3) {
/* 099 */
/* 100 */
/* 101 */
/* 102 */         isNull2 = false; // resultCode could change nullability.
/* 103 */         value2 = value3.substringSQL(1, 30);
/* 104 */
/* 105 */       }
/* 106 */       isNullA2 = isNull2;
/* 107 */       primitiveA2 = value2;
/* 108 */     }
/* 109 */     i = b;
/* 110 */     boolean isNullB2;
/* 111 */     UTF8String primitiveB2;
/* 112 */     {
/* 113 */
/* 114 */       boolean isNull2 = true;
/* 115 */       UTF8String value2 = null;
/* 116 */
/* 117 */       boolean isNull3 = i.isNullAt(6);
/* 118 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(6));
/* 119 */       if (!isNull3) {
/* 120 */
/* 121 */
/* 122 */
/* 123 */         isNull2 = false; // resultCode could change nullability.
/* 124 */         value2 = value3.substringSQL(1, 30);
/* 125 */
/* 126 */       }
/* 127 */       isNullB2 = isNull2;
/* 128 */       primitiveB2 = value2;
/* 129 */     }
/* 130 */     if (isNullA2 && isNullB2) {
/* 131 */       // Nothing
/* 132 */     } else if (isNullA2) {
/* 133 */       return -1;
/* 134 */     } else if (isNullB2) {
/* 135 */       return 1;
/* 136 */     } else {
/* 137 */       int comp = primitiveA2.compare(primitiveB2);
/* 138 */       if (comp != 0) {
/* 139 */         return comp;
/* 140 */       }
/* 141 */     }
/* 142 */
/* 143 */
/* 144 */     i = a;
/* 145 */     boolean isNullA3;
/* 146 */     double primitiveA3;
/* 147 */     {
/* 148 */
/* 149 */       boolean isNull6 = i.isNullAt(5);
/* 150 */       double value6 = isNull6 ? -1.0 : (i.getDouble(5));
/* 151 */       isNullA3 = isNull6;
/* 152 */       primitiveA3 = value6;
/* 153 */     }
/* 154 */     i = b;
/* 155 */     boolean isNullB3;
/* 156 */     double primitiveB3;
/* 157 */     {
/* 158 */
/* 159 */       boolean isNull6 = i.isNullAt(5);
/* 160 */       double value6 = isNull6 ? -1.0 : (i.getDouble(5));
/* 161 */       isNullB3 = isNull6;
/* 162 */       primitiveB3 = value6;
/* 163 */     }
/* 164 */     if (isNullA3 && isNullB3) {
/* 165 */       // Nothing
/* 166 */     } else if (isNullA3) {
/* 167 */       return -1;
/* 168 */     } else if (isNullB3) {
/* 169 */       return 1;
/* 170 */     } else {
/* 171 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA3, primitiveB3);
/* 172 */       if (comp != 0) {
/* 173 */         return comp;
/* 174 */       }
/* 175 */     }
/* 176 */
/* 177 */     return 0;
/* 178 */   }
/* 179 */ }
